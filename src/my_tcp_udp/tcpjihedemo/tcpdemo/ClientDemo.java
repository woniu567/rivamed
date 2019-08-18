package my_tcp_udp.tcpjihedemo.tcpdemo;


import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.net.Socket;

public class ClientDemo {

    public void go() {
        try {
            // 创建socket
            Socket socketClient = new Socket("127.0.0.1", 8018);
            // 向服务器发送消息
            PrintWriter ps = new PrintWriter(socketClient.getOutputStream());
            /*ps.write("message to send!");
            ps.write("another message!");
            ps.close();*/
            // 从服务器读取消息
            /* InputStreamReader inputStreamReader = new InputStreamReader(socketClient.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            System.out.println("Client receive msg: " + s);
            inputStreamReader.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientDemo sc = new ClientDemo();
        sc.go();
    }

}
