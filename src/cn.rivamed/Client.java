package cn.rivamed;

import java.io.IOException;

public class Client {

    public static void main(String[] args) {

        ClientHandler clientHandler = new ClientHandler();

        try {
            clientHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
