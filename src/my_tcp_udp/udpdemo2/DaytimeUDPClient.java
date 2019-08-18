package my_tcp_udp.udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*

UDP协议

在有些应用程序中，保持最快的速度比保证每一位数据都正确到达更重要。例如，在实时音频或视频中，丢失数据包只会作为干扰出现。
干扰是可以容忍的，但当TCP请求重传或等待数据包到达而它却迟迟不到时，音频流中就会出现尴尬的停顿，这让人无法接受的。
在其他应用中，可以在应用层实现可靠性传输。例如：如果客户端向服务器发送一个短的UDP请求，倘若制定时间内没有响应返回，
它会认为这个包已丢失。域名系统就是采用这样的工作方式。事实上，可以用UDP实现一个可靠的文件传输协议，
而且很多人确实是这样做的：网络文件系统，简单FTP都使用了UDP协议。在这些协议中由应用程序来负责可靠性。
java中的UDP实现分为两个类：DatagramPacket和 DatagramSocket。DatagramPacket类将数据字节填充到UDP包中，这称为数据报。
DatagramSocket来发送这个包。要接受数据，可以从DatagramSocket中接受一个 DatagramPack对象，然后从该包中读取数据的内容。


这种职责的划分与TCP使用的Socket和ServerSocket有所不同。首先，UDP没有两台主机间唯一连接的概念，它不需要知道对方是哪个远程主机。
它可以从一个端口往多个主机发送信息，但是TCP是无法做到的。其次，TCP socket把网络链接看作是流：通过从Socket得到的输入和输出流来收发数据。
UDP不支持这一点，你处理总是单个数据包。填充在一个数据报中的所有数据会以包的形式进行发送，这些数据要么作为一个组要么全部接收，要么全部丢弃。
一个包不一定与下一个包相关。给定两个包，没有办法知道哪个先发哪个后发。对于流来说，必须提供数据的有序队列，与之不同，数据报会尽可能快的蜂拥到接收方。

 */

public class DaytimeUDPClient {

    private final static int PORT = 13;
    private static final String HOSTNAME = "www.xdysite.cn";

    public static void main(String[] args) {
        //传入0表示让操作系统分配一个端口号
        try (DatagramSocket socket = new DatagramSocket(0)) {

            //socket.setSoTimeout(8000);
            //InetAddress host = InetAddress.getByName(HOSTNAME);
            InetAddress host = InetAddress.getLocalHost();

            //指定包要发送的目的地
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
            //为接受的数据包创建空间
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(response);
            String result = new String(response.getData(), 0, response.getLength(), "ASCII");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
