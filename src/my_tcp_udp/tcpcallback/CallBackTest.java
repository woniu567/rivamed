package my_tcp_udp.tcpcallback;

public class CallBackTest {

    public static void main(String[] args) {

        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("Server,Hello~");
    }
}
