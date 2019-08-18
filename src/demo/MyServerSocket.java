package demo;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    public static void main(String[] args) {

        new ServerListener().start();
    }
}
