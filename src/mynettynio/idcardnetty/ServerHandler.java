package mynettynio.idcardnetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println("serverHandler receive msg:"+msg.toString());

        ctx.channel().writeAndFlush("this is serverHandler reply msg!" + System.currentTimeMillis());

        //ctx.fireChannelRead(msg);
    }
}
