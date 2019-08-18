package mynettynio.nettydemo.demo1;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.io.IOException;
import java.util.List;

public class NettyClient {

    public static void main(String[] args) {

        NettyClient nettyClient = new NettyClient();
        nettyClient.startClient();
    }

    public void startClient() {
        //1.定义服务类
        Bootstrap clientBootstap = new Bootstrap();

        //2.定义执行线程组
        EventLoopGroup worker = new NioEventLoopGroup();

        //3.设置线程池
        clientBootstap.group(worker);

        //4.设置通道
        clientBootstap.channel(NioSocketChannel.class);

        //5.添加Handler
        clientBootstap.handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                System.out.println("client channel init!");
                ChannelPipeline pipeline = channel.pipeline();
                // 解析客户端发送的文本json
//                pipeline.addLast(new ObjectDecoder());
                // 二进制文件加密传输
                //pipeline.addLast(new ObjectEncoder());

                pipeline.addLast(new MessageToMessageDecoder<ByteBuf>(){
                    @Override
                    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
                        final int length = msg.readableBytes();
                        final byte[] array = new byte[length];
                        msg.getBytes(msg.readerIndex(), array, 0, length);
                        out.add(array);
                    }
                });

                pipeline.addLast(new MessageToByteEncoder<byte[]>(){
                    @Override
                    protected void encode(ChannelHandlerContext ctx, byte[] msg, ByteBuf out) throws IOException {
                        out.writeBytes(msg);
                    }
                });

                pipeline.addLast("ClientHandler", new NettyClientHandler());
            }
        });

        //6.建立连接
        ChannelFuture channelFuture = clientBootstap.connect("192.168.10.206", 8018);
        System.out.println("建立连接：：" + (channelFuture != null));
        try {
            //7.测试输入
            while (true) {
                System.out.println("请输入：");
                byte[] send = show();
                channelFuture.channel().writeAndFlush(send);
            }

            /*ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
            scheduledThreadPool.schedule(new Runnable() {
               public void run() {
                   byte[] send = show();
                    channelFuture.channel().writeAndFlush(send);
                    System.out.println("发送数据了");
                }
            }, 10, TimeUnit.SECONDS);*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //8.关闭连接
            worker.shutdownGracefully();
        }
    }
    public byte[] show() {
        byte[] buf = new byte[24];
        buf[0] = (byte) 0xFC;
        buf[1] = (byte) 0xFC;
        buf[2] = (byte) 0x07;
        buf[3] = (byte) 0x01;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        buf[7] = (byte) 0x01;
        buf[8] = (byte) 0x00;
        buf[9] = (byte) 0x0C;
        buf[10] = (byte) 0xCF;
        buf[11] = (byte) 0xBA;
        buf[12] = (byte) 0xCE;
        buf[13] = (byte) 0xAE;
        buf[14] = (byte) 0x0A;
        buf[15] = (byte) 0x1C;
        buf[16] = (byte) 0xD0;
        buf[17] = (byte) 0x12;
        buf[18] = (byte) 0x10;
        buf[19] = (byte) 0x33;
        buf[20] = (byte) 0x22;
        buf[21] = (byte) 0x01;
        buf[22] = (byte) 0x3D;
        buf[23] = (byte) 0x8C;

        /*buf[24] = (byte) 0xFC;
        buf[25] = (byte) 0xFC;
        buf[26] = (byte) 0x07;
        buf[27] = (byte) 0x01;
        buf[28] = (byte) 0x00;
        buf[29] = (byte) 0x00;
        buf[30] = (byte) 0x00;
        buf[31] = (byte) 0x01;
        buf[32] = (byte) 0x00;
        buf[33] = (byte) 0x0C;
        buf[34] = (byte) 0xCF;
        buf[35] = (byte) 0xBA;
        buf[36] = (byte) 0xCE;
        buf[37] = (byte) 0xFC;
        buf[38] = (byte) 0x0A;
        buf[39] = (byte) 0x1C;
        buf[40] = (byte) 0xD0;
        buf[41] = (byte) 0x12;
        buf[42] = (byte) 0x10;
        buf[43] = (byte) 0x33;
        buf[44] = (byte) 0x22;
        buf[45] = (byte) 0x02;
        buf[46] = (byte) 0x5F;
        buf[47] = (byte) 0x29;*/

        /*buf[48] = (byte) 0xFC;
        buf[49] = (byte) 0xFC;
        buf[50] = (byte) 0x07;
        buf[51] = (byte) 0x01;
        buf[52] = (byte) 0x00;
        buf[53] = (byte) 0x00;
        buf[54] = (byte) 0x00;
        buf[55] = (byte) 0x01;
        buf[56] = (byte) 0x00;
        buf[57] = (byte) 0x0C;
        buf[58] = (byte) 0xCF;
        buf[59] = (byte) 0xBA;
        buf[60] = (byte) 0xCE;
        buf[61] = (byte) 0xFC;
        buf[62] = (byte) 0x0A;
        buf[63] = (byte) 0x1C;
        buf[64] = (byte) 0xD0;
        buf[65] = (byte) 0x12;
        buf[66] = (byte) 0x10;
        buf[67] = (byte) 0x33;
        buf[68] = (byte) 0x22;
        buf[69] = (byte) 0x03;
        buf[70] = (byte) 0x9F;
        buf[71] = (byte) 0xE8;*/

        /*buf[72] = (byte) 0xFC;
        buf[73] = (byte) 0xFC;
        buf[74] = (byte) 0x07;
        buf[75] = (byte) 0x01;
        buf[76] = (byte) 0x00;
        buf[77] = (byte) 0x00;
        buf[78] = (byte) 0x00;
        buf[79] = (byte) 0x01;
        buf[80] = (byte) 0x00;
        buf[81] = (byte) 0x0C;
        buf[82] = (byte) 0xCF;
        buf[83] = (byte) 0xBA;
        buf[84] = (byte) 0xCE;
        buf[85] = (byte) 0xFC;
        buf[86] = (byte) 0x0A;
        buf[87] = (byte) 0x1C;
        buf[88] = (byte) 0xD0;
        buf[89] = (byte) 0x12;
        buf[90] = (byte) 0x10;
        buf[91] = (byte) 0x33;
        buf[92] = (byte) 0x22;
        buf[93] = (byte) 0x04;
        buf[94] = (byte) 0x5D;
        buf[95] = (byte) 0xA9;*/

        /*buf[96] = (byte) 0xFC;
        buf[97] = (byte) 0xFC;
        buf[98] = (byte) 0x07;
        buf[99] = (byte) 0x01;
        buf[100] = (byte) 0x00;
        buf[101] = (byte) 0x00;
        buf[102] = (byte) 0x00;
        buf[103] = (byte) 0x01;
        buf[104] = (byte) 0x00;
        buf[105] = (byte) 0x0C;
        buf[106] = (byte) 0xCF;
        buf[107] = (byte) 0xBA;
        buf[108] = (byte) 0xCE;
        buf[109] = (byte) 0xFC;
        buf[110] = (byte) 0x0A;
        buf[111] = (byte) 0x1C;
        buf[112] = (byte) 0xD0;
        buf[113] = (byte) 0x12;
        buf[114] = (byte) 0x10;
        buf[115] = (byte) 0x33;
        buf[116] = (byte) 0x22;
        buf[117] = (byte) 0x05;
        buf[118] = (byte) 0x9D;
        buf[119] = (byte) 0x68;*/

        /*buf[120] = (byte) 0xFC;
        buf[121] = (byte) 0xFC;
        buf[122] = (byte) 0x07;
        buf[123] = (byte) 0x01;
        buf[124] = (byte) 0x00;
        buf[125] = (byte) 0x00;
        buf[126] = (byte) 0x00;
        buf[127] = (byte) 0x01;
        buf[128] = (byte) 0x08;*/

        return buf;
    }

}
