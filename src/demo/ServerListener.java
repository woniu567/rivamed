package demo;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{

    @Override
    public void run() {
        super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true){
                Socket socket = serverSocket.accept();//block
                JOptionPane.showMessageDialog(null,"有客户端连接到12345端口了");//建立连接
                //将socket传递给新的线程
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
