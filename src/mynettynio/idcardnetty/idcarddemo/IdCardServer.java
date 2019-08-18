package mynettynio.idcardnetty.idcarddemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class IdCardServer {

    /*static final int PORT = Integer.parseInt(System.getProperty("port","40002"));

    public static void main(String[] args) {

        EventLoopGroup boss = new NioEventLoopGroup(1);
        //EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap sb = new ServerBootstrap();
        sb.group(boss)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new IdCardServerHandler());
        try {
            ChannelFuture cf = sb.bind(PORT).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
        }
    }*/

    private final int port;

    public IdCardServer(int port){
        this.port = port;
    }

    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(this.port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new IdCardServerHandler());
                        }
                    });
            ChannelFuture cf = sb.bind().sync();
            cf.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception{
        new IdCardServer(40002).start();
    }
}
