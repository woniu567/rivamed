package my_tcp_udp.tcpjihedemo.jihedemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.StringUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class GetRemoteIp extends ChannelInboundHandlerAdapter {

    public GetRemoteIp(){}

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    ChannelHandlerContext ctx;

    public String getRemoteIP() {
            String address = this.getCtx() == null ? "" : this.getCtx().pipeline().channel().remoteAddress().toString();

            if (!StringUtil.isNullOrEmpty(address)) {
                address = address.replace("/", "");
                address = address.substring(0, address.indexOf(":"));
            }
            return address;
    }

    public static void main(String[] args) {

        ServerSocket ss = null;
        ServerSocket ss1 = null;
        ServerSocket ss2 = null;
        try {
            ss = new ServerSocket(8014);
            //ss1 = new ServerSocket(40002);
            //ss2 = new ServerSocket(40003);
            Socket socket = ss.accept();
            //Socket socket1 = ss1.accept();
            //Socket socket2 = ss2.accept();
            /*********************************************** READER的IP **********************************************/
            SocketAddress remoteIpAddress = socket.getRemoteSocketAddress();
            String ipstr = remoteIpAddress.toString().split(":")[0];
            String str = ipstr.substring(1,ipstr.length());
            System.out.println(str);
            /*********************************************** ID卡的IP **********************************************/
            /*SocketAddress remoteIpAddress1 = socket1.getRemoteSocketAddress();
            String ipstr1 = remoteIpAddress1.toString().split(":")[0];
            String str1 = ipstr.substring(1,ipstr1.length());
            System.out.println(str1);*/
            /*********************************************** 指纹仪的IP **********************************************/
            /*SocketAddress remoteIpAddress2 = socket2.getRemoteSocketAddress();
            String ipstr2 = remoteIpAddress2.toString().split(":")[0];
            String str2 = ipstr.substring(1,ipstr2.length());
            System.out.println(str2);*/
            /*********************************************** 得到远端的IP **********************************************/
            /*GetRemoteIp getRemoteIp = new GetRemoteIp();
            String string = getRemoteIp.getRemoteIP();
            System.out.println(string.toString());*/

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
