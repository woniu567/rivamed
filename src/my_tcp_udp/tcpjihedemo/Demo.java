package my_tcp_udp.tcpjihedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo {

    //0x01,0x00,0x03,0x0f,0x00,0x13

    public static final byte HEAD_1 = (byte)0xef;
    public static final byte HEAD_2 = (byte)0x01;
    public static final byte ADRESS_1 = (byte)0xff;
    public static final byte ADRESS_2 = (byte) 0xff;
    public static final byte ADRESS_3 = (byte) 0xff;
    public static final byte ADRESS_4 = (byte) 0xff;
    public static final byte BIAOSHI = (byte) 0x01;
    public static final byte LEN_1 = (byte) 0x00;
    public static final byte LEN_2 = (byte) 0x03;
    public static final byte CMD = (byte) 0x0f;
    public static final byte CRC_1 = (byte) 0x00;
    public static final byte CRC_2 = (byte) 0x13;

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("192.168.0.18",50005);
            OutputStream outputStream = socket.getOutputStream();

            byte[] bytes = new byte[]{HEAD_1,HEAD_2,ADRESS_1,ADRESS_2,ADRESS_3,ADRESS_4,BIAOSHI,LEN_1,LEN_2,CMD,CRC_1,CRC_2};
            outputStream.write(bytes);

            InputStream inputStream = socket.getInputStream();
            byte[] by = new byte[1024];
            inputStream.read(by);
            String str = toHex(by);
            String[] str2 = str.split("");
            System.out.println(str2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String toHex(byte[] result) {
        StringBuffer sb = new StringBuffer(result.length * 2);
        for (int i = 0; i < result.length; i++) {
            sb.append(Character.forDigit((result[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(result[i] & 15, 16));
        }
        return sb.toString();
    }
}
