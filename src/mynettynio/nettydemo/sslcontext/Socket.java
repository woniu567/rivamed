package mynettynio.nettydemo.sslcontext;

public class Socket {
    public Socket(String localhost, int i) {
    }

    /*// 通过socket连接服务器
    public static void socket() throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 10002);
        System.out.println(s);
        System.out.println("ok");

        OutputStream output = s.getOutputStream();
        InputStream input = s.getInputStream();

        output.write("alert".getBytes());
        System.out.println("sent: alert");
        output.flush();

        byte[] buf = new byte[1024];
        int len = input.read(buf);
        System.out.println("received:" + new String(buf, 0, len));
    }*/
}
