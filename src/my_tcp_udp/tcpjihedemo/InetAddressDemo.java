package my_tcp_udp.tcpjihedemo;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void main(String[] args) {

        try {
            String address = InetAddress.getLocalHost().getHostAddress().toString();
            String ipv4Address = Inet4Address.getLocalHost().getHostAddress().toString();
            System.out.println("本机IP是：" + address);
            System.out.println("本机IPV4是："+ipv4Address);
            //ub = new URIBuilder("http://192.168.100.110:8018/sth/inventory/recoveryOrder")
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
