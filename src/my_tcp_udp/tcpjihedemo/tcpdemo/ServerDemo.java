package my_tcp_udp.tcpjihedemo.tcpdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerDemo {

    public void go() {
        try {
            ServerSocket ss = new ServerSocket(5000);
            while (true) {
                Socket socket = ss.accept();
                /* PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println("Send Message!");
                printWriter.close();*/
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s = bufferedReader.readLine();
                System.out.println(s);
                inputStreamReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerDemo ss = new ServerDemo();
        ss.go();
    }

}
