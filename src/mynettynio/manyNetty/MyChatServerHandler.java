package mynettynio.manyNetty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

//自定义Handler
public class MyChatServerHandler extends SimpleChannelInboundHandler<String>{

    //保留所有与服务器建立连接的channel对象，这边的GlobalEventExecutor在写博客的时候解释一下，看其doc
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    protected static Map<String, ChannelHandlerContext> mapContext = new HashMap<>();

    private ChannelHandlerContext context;

    /**
     * 服务器端收到任何一个客户端的消息都会触发这个方法
     * 连接的客户端向服务器端发送消息，那么其他客户端都收到此消息，自己收到【自己】+消息
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if(channel !=ch){
                ch.writeAndFlush(channel.remoteAddress() +" 发送的消息:" +msg+" \n");
            }else{
                ch.writeAndFlush(" 【自己】"+msg +" \n");
                this.everyChannel(msg);
            }
        });
    }

    //表示服务端与客户端连接建立
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();  //其实相当于一个connection
        context = ctx;
        /**
         * 调用channelGroup的writeAndFlush其实就相当于channelGroup中的每个channel都writeAndFlush
         *
         * 先去广播，再将自己加入到channelGroup中
         */
        channelGroup.writeAndFlush(" 【服务器】 -" +channel.remoteAddress() +" 加入\n");
        channelGroup.add(channel);
        SocketAddress remoteAddress = channel.remoteAddress();
        String string = remoteAddress.toString();
        String ip = string.substring(string.indexOf("/")+1,string.indexOf(":"));
        mapContext.put(ip,context);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(" 【服务器】 -" +channel.remoteAddress() +" 离开\n");

        //验证一下每次客户端断开连接，连接自动地从channelGroup中删除调。
        System.out.println(channelGroup.size());
        //当客户端和服务端断开连接的时候，下面的那段代码netty会自动调用，所以不需要人为的去调用它
        //channelGroup.remove(channel);
    }

    //连接处于活动状态
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() +" 上线了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() +" 下线了");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public void everyChannel(String ip) {
        if (mapContext.containsKey(ip)){
            ChannelHandlerContext context = mapContext.get(ip);
            Channel channel = context.channel();
            channel.writeAndFlush("dfadsfdsrfewrwerqw");
        }
    }
}
