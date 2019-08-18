package mynettynio.nettydemo.demo1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler1 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ServerHandler1 receive msg:"+msg.toString());

        //写消息：先得到channel，在写如通道然后flush刷新通道把消息发出去。
        ctx.channel().writeAndFlush("this is ServerHandler1 reply msg happend at !"+System.currentTimeMillis());

        //把消息往下一个Handler传
        ctx.fireChannelRead(msg);
    }
}
