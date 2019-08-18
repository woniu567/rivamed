package zhiwendemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;


public class FingerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("通道开始读取");//将接受到的数据打印到控制台
        ByteBuf in = (ByteBuf) msg;

        try {
            if(in.isReadable()) {
                byte[] readBytes = new byte[in.readableBytes()];
                in.readBytes(readBytes);
                String readStr = toHex(readBytes);
                System.out.println(readStr);
            }
//            while (in.isReadable()) { // (1)
//                System.out.print(in.readByte());//将接受到的数据打印到控制台
//                System.out.flush();
//            }

        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("通道读取完毕");//将接受到的数据打印到控制台
        // 读写完毕，调用flush将数据真正发送到客户端
        //ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)
    {
        //方式一
        byte[] s=SendGetId();
        System.out.println("通道激活");//将接受到的数据打印到控制台
        System.out.println("发送命令："+toHex(s));
        //String strSend=toHex(s)+"\n";

        //ctx.writeAndFlush(strSend); 错的
        //ctx.writeAndFlush(strSend.getBytes()); 错的
        //ctx.writeAndFlush(Unpooled.copiedBuffer(strSend.getBytes())); //正确的
        //方式二
        ctx.writeAndFlush(Unpooled.copiedBuffer(s));//
        //ChannelHandlerContext(DefaultChannelPipeline$TailContext#0,
        // [id: 0x17f666d4, L:/192.168.100.192:40003 - R:/192.168.100.12:53584])
    }
    //获取设备ID,三能指纹仪
    private byte[] SendGetId()
    {

        byte[] bytes = new byte[26];
        bytes[0] =  (byte)0x55; //头部
        bytes[1] =  (byte)0xAA; //头部
        bytes[2] =  (byte)0x01; //SID
        bytes[3] =  (byte)0x01; //DID
        bytes[4] =  (byte)0x03; //CMD
        bytes[5] =  (byte)0x00; //CMD
        bytes[6] =  (byte)0x01; //LEN
        bytes[7] =  (byte)0x00; //LEN
        bytes[8] =  (byte)0x00; //DATA
        bytes[9] =  (byte)0x00; //DATA
        bytes[10] = (byte)0x00; //DATA
        bytes[11] = (byte)0x00; //DATA
        bytes[12] = (byte)0x00; //DATA
        bytes[13] = (byte)0x00; //DATA
        bytes[14] = (byte)0x00; //DATA
        bytes[15] = (byte)0x00; //DATA
        bytes[16] = (byte)0x00; //DATA
        bytes[17] = (byte)0x00; //DATA
        bytes[18] = (byte)0x00; //DATA
        bytes[19] = (byte)0x00; //DATA
        bytes[20] = (byte)0x00; //DATA
        bytes[21] = (byte)0x00; //DATA
        bytes[22] = (byte)0x00; //DATA
        bytes[23] = (byte)0x00; //DATA
        bytes[24] = (byte)0x05;
        bytes[25] = (byte)0x01;

        //02 08 B0 00 00 00 00 45
        byte[] buf = new byte[8];
        buf[0] = (byte) 0x02;
        buf[1] = (byte)0x08;
        buf[2] = (byte)0xB0;
        buf[3] = (byte) 0x00;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        CheckSum(buf,(byte) buf.length);

    return buf;
    }

    private String toHex(byte[] result)
    {
        StringBuffer sb=new StringBuffer(result.length*2);
        for(int i=0;i<result.length;i++)
        {
            sb.append(Character.forDigit((result[i] & 240) >>4,16));
            sb.append((Character.forDigit((result[i] & 15),16)));
        }
        return sb.toString();
    }

    public static void CheckSum(byte[] buf, byte len) {
        byte i;
        byte checksum;
        checksum = 0;
        for (i = 0; i < (len - 1); i++)
        {
            checksum ^= buf[i];
        }
        buf[len - 1] = (byte)~checksum;
    }
}
