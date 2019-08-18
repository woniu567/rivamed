//package demo.nettydemo;
//
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
//import java.net.InetSocketAddress;
//import java.util.Scanner;
//
///*
//
//我需要的效果：
//
//        1.客户端与服务端长连接TCP通信；
//
//        2.客户端通过自定义解码器，解析服务端返回的数据包；
//
//        3.客户端在服务端返回连接结果后，发送登录请求数据包，需要对数据自定义编码器解析；
//
//        4.因为是长连接，服务不能断，还需要发送登陆请求，以及其他验证消息。很重要。
//
//数据包结构：
//
//        1.固定包头2字节；
//
//        2.消息体，全部为文本(ASCII码)，汉字是GB2312编码。
//
//        3.固定包尾2字节；
//
// */
//
//public class TCPClient {
//
//    public void connect(int port,String host)throws Exception{
//        //网络事件处理线程组
//        EventLoopGroup group=new NioEventLoopGroup();
//
//        //配置客户端启动类
//        Bootstrap b=new Bootstrap();
//        b.group(group).channel(NioSocketChannel.class)
//                .option(ChannelOption.TCP_NODELAY, true)//设置封包 使用一次  大数据的写操作，而不是多次小数据的写操作
//                .handler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel ch) throws Exception {
//                        //ch.pipeline().addLast("decoder",new DealMsg());      //设置自定义解码器
//                        //ch.pipeline().addLast("encoder",new MsgEncode()); //设置自定义编码器
//                        ch.pipeline().addLast(new TCPClientHandler());    //设置客户端网络IO处理器
//                    }
//                });
//        //连接服务器 同步等待成功
//        ChannelFuture f = b.connect(new InetSocketAddress(host,port));
//        //同步等待客户端通道关闭  // f.channel().closeFuture().sync(); //不关闭会发生阻塞
//        Channel channel = f.sync().channel();
//
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            System.out.println("请输入");
//            //CarData carData = new CarData();
//            String line = scanner.nextLine();
//            //carData.setBody(line);
//            //发送请求
//            //channel.writeAndFlush(carData);
//
//        }
//
//        //释放线程组资源
//// group.shutdownGracefully();
//    }
//
//
//}
