package mynettynio.idcardnetty.idcarddemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class IdCardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("读取到IC的数据：");
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString());
        int a = in.readableBytes();
        System.out.println(a);
        byte[] bytes = new byte[a];
        in.readBytes(bytes);
        CheckSum(bytes,(byte) a);
        System.out.println(bytes);
        String str = toHex(bytes);
        System.out.println(str.toString());


    }


    public static void CheckSum(byte[] buf, byte len){
        byte i;
        byte checksum;
        checksum = 0;
        for (i = 0; i < (len - 1); i++)
        {
            checksum ^= buf[i];
        }
        buf[len - 1] = (byte)~checksum;
    }

    private static String toHex(byte[] result) {
        StringBuffer sb = new StringBuffer(result.length * 2);
        for (int i = 0; i < result.length; i++) {
            sb.append(Character.forDigit((result[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(result[i] & 15, 16));
        }
        return sb.toString();
    }
}
