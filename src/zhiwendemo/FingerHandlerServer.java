package zhiwendemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * 描述: 服务端代码
 * 公司: 北京瑞华康源科技有限公司
 * 版权: rivamed2018
 *
 * @author Eamonn
 * @version V1.0
 * @date 2018-12-17 18:42:11
 */
public class FingerHandlerServer {

    private int port;

    public FingerHandlerServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {


        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)// 接受连接事件组
        EventLoopGroup workerGroup = new NioEventLoopGroup();// 处理每个连接业务事件组
        try {

            ServerBootstrap b = new ServerBootstrap(); // (2)

            b.group(bossGroup, workerGroup)// 可以只使用一个group，分成两个group的好处是：业务耗时较长导致阻塞时，不会对接受连接造成影响。
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)

                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {

                            ch.config().setOption(ChannelOption.SO_KEEPALIVE, true);
                            ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
                            FingerHandler channelHandler = new FingerHandler();
                            ch.config().setOption(ChannelOption.SO_RCVBUF, 1024);
                            //ch.pipeline().addLast(new IdleStateHandler(5, 0, 0));
                            /**
                             *
                             * maxFrameLength 为信息最大长度，超过这个长度回报异常，
                             * lengthFieldOffset 为长度属性的起始（偏移）位，
                             * lengthFieldLength 为“长度属性”的长度，
                             * lengthAdjustment  为长度调节值，在总长被定义为包含包头长度时，修正信息长度，不包含为0，包含 则为负数
                             * initialBytesToStrip 为跳过的字节数，从长度属性结束的位置往前数，
                             *
                             * */
                            //ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(30000, 6, 2, 0, 0));

                            ch.pipeline().addLast(channelHandler);//  将业务处理器加到通道管理线（处理器队列）的末尾



                        }
                    })

                    .option(ChannelOption.SO_BACKLOG, 2048)
                    .childOption(ChannelOption.TCP_NODELAY, true)//后加的
                    .childOption(ChannelOption.SO_KEEPALIVE, true);


           // ChannelFuture f = b.bind(port).sync();// 绑定指定端口
            ChannelFuture f = b.bind().sync();// 绑定指定端口
            System.out.println(FingerHandlerServer.class.getName() + " started and listen on " + f.channel().localAddress());

            f.channel().closeFuture().sync();
        } finally {
            System.out.println("释放资源");
            workerGroup.shutdownGracefully(); // 释放资源和线程池
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        int port = 40002;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }


        new FingerHandlerServer(port).run();


    }
}
