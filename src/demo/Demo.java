package demo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Demo {

    private static final byte HEAD = (byte)0xA0;
    private static final byte LEN = (byte)0x40;
    private static final byte ADRESS = (byte)0x01;
    private static final byte CMD = (byte)0x89;
    private static final byte REAPEAT = (byte)0xFF;
    //private Socket socket;

    public static void main(String[] args) {

        /*System.out.println("hello word!");
        for (int i = 0; i < 10; i++) {
            System.out.print("log" + i + " ");
        }*/

        byte[] bytes = new byte[6];
        bytes[0] = HEAD;
        bytes[1] = LEN;
        bytes[2] = ADRESS;
        bytes[3] = CMD;
        bytes[4] = REAPEAT;
        bytes[5] = (byte) checkSum(bytes,0,bytes.length-1);
        byte[] bytes1 = new byte[6];

        try {
            Socket socket = new Socket("192.168.11.172",5000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            InputStream inputStream = socket.getInputStream();
            inputStream.read(bytes1);
            System.out.println(toHex(bytes1).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int checkSum(byte[] buf, int offset, int len) {
        int uSum = 0;
        for (int i = 0; i < len; i++) {
            int v = buf[i + offset];
            uSum += 0xff & v;
        }
        uSum = (~(uSum & 0xff)) + 1;
        return (uSum) & 0xff;
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
