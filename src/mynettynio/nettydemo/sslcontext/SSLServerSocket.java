package mynettynio.nettydemo.sslcontext;

import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;

public class SSLServerSocket {

    // 抛出异常
// javax.net.ssl.SSLException: No available certificate or key corresponds
// to the SSL cipher suites which are enabled.
    /*public static void notOk() throws IOException {
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        SSLServerSocket server = (SSLServerSocket) factory
                .createServerSocket(10000);
        System.out.println("ok");
        server.accept();
    }*/
}
