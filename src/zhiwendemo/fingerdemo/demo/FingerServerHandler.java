package zhiwendemo.fingerdemo.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class FingerServerHandler extends ChannelInboundHandlerAdapter {



    int fingerRegisterTimer = 0;
    Thread fingerRegStateThread = new Thread(()->{

        System.out.println("指纹注册监控线程启动");
        while (fingerRegisterTimer<40){//指纹注册最长等待时间为30s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fingerRegisterTimer ++;
        }
    });

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        System.out.println("channelread事件发生!");
        ByteBuf in = (ByteBuf) msg;
        if (in.isReadable()){
            byte[] readBytes = new byte[in.readableBytes()];
            in.readBytes(readBytes);
            String readStr = toHex(readBytes);
            System.out.println("接收到客户端发送过来的消息的总长度为："+readBytes.length+"消息内容为："+readStr);
            String readStrHead = readStr.substring(0,4).toUpperCase();
            switch (readStrHead){
                case "AA55"://响应包
            }

        }


    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
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

}
