package my_tcp_udp.tcpjihedemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class GetRemoteIp {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(40003);
            Socket socket = ss.accept();
            SocketAddress ip = socket.getRemoteSocketAddress();
            System.out.println(ip.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
