package mynettynio.idcardnetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class Server {

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer(){

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        serverBootstrap.group(boss,work);

        serverBootstrap.channel(NioServerSocketChannel.class);

        serverBootstrap.childHandler(new ChannelInitializer<Channel>() {

            @Override
            protected void initChannel(Channel channel) throws Exception {
                ChannelPipeline pipeline = channel.pipeline();
                pipeline.addLast(new StringDecoder());
                pipeline.addLast("serverHandler",new ServerHandler());
                pipeline.addLast(new StringEncoder());

                System.out.println("success to initHandler!");
            }
        });
        serverBootstrap.option(ChannelOption.SO_BACKLOG,2048);
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY,true);

        try {
            ChannelFuture channelFuture = serverBootstrap.bind("127.0.0.1",9099).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            System.out.println("server start got exception!");
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }

}
