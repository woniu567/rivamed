package my_tcp_udp.tcpjihedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class RfidDemo {

    private boolean running=false;
    private long lastSendTime;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            //02 08 B0 00 00 00 00 45
            byte[] by = new byte[8];
            by[0] = (byte)0x02;
            by[1] = (byte)0x08;
            by[2] = (byte)0xB0;
            by[3] = (byte)0x00;
            by[4] = (byte)0x00;
            by[5] = (byte)0x00;
            by[6] = (byte)0x00;
            //by[7] = (byte)0x45;
            CheckSum(by,(byte) 8);

            serverSocket = new ServerSocket(40002);
            Socket s = serverSocket.accept();
            OutputStream outputStream = s.getOutputStream();
            //outputStream.write(by);

            InputStream inputStream = s.getInputStream();
            System.out.println(inputStream.available());
            if (inputStream.available() == 0){
                System.out.println("null");

            }else {
                byte[] bytes = new byte[12];
                inputStream.read(bytes);
                CheckSum(bytes,(byte)12);
                String str = toHex(bytes);
                String[] str1 = str.split("");
                ttoString(str1);
                System.out.println(str1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void CheckSum(byte[] buf, byte len)
    {
        byte i;
        byte checksum;
        checksum = 0;
        for (i = 0; i < (len - 1); i++)
        {
            checksum ^= buf[i];
        }
        buf[len - 1] = (byte)~checksum;
    }


    /*public static int CheckSum(byte[] buf,int offset,int len){

        int i=0,checksum = 0;
        for(i=0;i<len;i++){
            int v = buf[i+offset];
            checksum ^= 0xff & v;
        }
        checksum = ~(checksum & 0xff);
        return checksum & 0xff;
    }*/


    public void start() throws UnknownHostException, IOException {
        if(running)
            return;
        //System.out.println("本地端口："+socket.getLocalPort());
        lastSendTime=System.currentTimeMillis();
        running=true;
        try {
            Thread.sleep(1000);
            new Thread(new RfidDemo.KeepAliveWatchDog()).start();
        }catch (Exception e){

        }
    }


    public void startReader() throws Exception{

        byte[] buf = new byte[4];
        buf[0] = (byte) 0xaa;

        byte[] by2 = new byte[17];
        //in2.read(by2);
        String str2 = toHex(by2);
        String[] str4 = str2.split("");
        String[] str5 = new String[getInt(str4)];
        System.arraycopy(str4,0,str5,0,getInt(str4));
        if(getInt(str4)>3)
            System.out.println(ttoString(str5));
        /*list = new ArrayList(set);
        System.out.println(list);*/
    }


    class KeepAliveWatchDog implements Runnable{

        long checkDelay = 10;
        long keepAliveDelay = 2000;

        public void run() {
            while(running){
                if(System.currentTimeMillis()-lastSendTime>keepAliveDelay){
                    try {
                        try {
                            RfidDemo.this.startReader();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        RfidDemo.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                }else{
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        RfidDemo.this.stop();
                    }
                }
            }
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

    public static int transfer(String[] strings){

        return Integer.parseInt(strings[3],16);
    }

    public static String ttoString(String[] sts){
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < sts.length; i++) {
            sb.append(sts[i]);
        }
        return sb.toString();
    }

    public static int getInt(String[] str){

        int a = Integer.parseInt(str[3],16);
        return 4+a*2;
    }

    public void stop(){
        if(running)
            running=false;
    }
}
