package mynettynio.nettydemo.sslcontext;

public class SSLSocket {

    /**
     * SSLSocket扩展Socket并提供使用SSL或TLS协议的安全套接字。
     * 这种套接字是正常的流套接字，但是它们在基础网络传输协议(如TCP)上添加了安全保护层。
     *
     * (1)SSLContext: 此类的实例表示安全套接字协议的实现， 它是SSLSocketFactory、SSLServerSocketFactory和SSLEngine的工厂。
     *
     * (2)SSLSocket: 扩展自Socket
     *
     * (3)SSLServerSocket: 扩展自ServerSocket
     *
     * (4)SSLSocketFactory: 抽象类，扩展自SocketFactory, SSLSocket的工厂
     *
     * (5)SSLServerSocketFactory: 抽象类，扩展自ServerSocketFactory, SSLServerSocket的工厂
     *
     * (6)KeyStore: 表示密钥和证书的存储设施
     *
     * (7)KeyManager: 接口，JSSE密钥管理器
     *
     * (8)TrustManager: 接口，信任管理器(?翻译得很拗口)
     *
     * (9)X590TrustedManager: TrustManager的子接口，管理X509证书，验证远程安全套接字
     */


    // 不使用证书, 通过ssl socket连接服务器
// 抛出异常, 提示找不到证书
    /*public static void sslSocket() throws UnknownHostException, IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory
                .getDefault();
        SSLSocket s = (SSLSocket) factory.createSocket("localhost", 10002);
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

    /*public static void sslSocket2() throws Exception {
        SSLContext context = SSLContext.getInstance("SSL");
        // 初始化
        context.init(null,
                new TrustManager[] { new Test2.MyX509TrustManager() },
                new SecureRandom());
        SSLSocketFactory factory = context.getSocketFactory();
        SSLSocket s = (SSLSocket) factory.createSocket("localhost", 10002);
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
