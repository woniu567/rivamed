package my_tcp_udp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*
 接收端的使用步骤
    1. 建立udp的服务
    2. 准备空的数据包接收数据。
    3. 调用udp的服务接收数据。
    4. 关闭资源
 */
//接收端
public class Receive {

    public static void main(String[] args) throws IOException {

        //建立udp的服务 ，并且要监听一个端口。
        DatagramSocket socket = new DatagramSocket(9090);

        //准备空的数据包用于存放数据。
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length); // 1024
        //调用udp的服务接收数据
        socket.receive(datagramPacket); //receive是一个阻塞型的方法，没有接收到数据包之前会一直等待。 数据实际上就是存储到了byte的自己数组中了。
        System.out.println("接收端接收到的数据："+ new String(buf,0,datagramPacket.getLength())); // getLength() 获取数据包存储了几个字节。
        System.out.println("receive阻塞了我，哈哈");


        //准备数据，把数据封装到数据包中。
        String data = "这个是我udp的回复...";
        //创建了一个数据包
        DatagramPacket packet = new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getLocalHost(),8989);
        //调用udp的服务发送数据包
        socket.send(packet);


        //关闭资源
        socket.close();
    }
}
