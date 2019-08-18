package my_tcp_udp.tcpjihedemo;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class RfidHandler {


    private boolean running=false;
    private long lastSendTime;
    private static Socket socket;

    ServerSocket ss;
    {
        try {
            ss = new ServerSocket(40002);
            socket = ss.accept();
            SocketAddress ip = socket.getRemoteSocketAddress();
            String[] arr = ip.toString().split(":");
            String str = arr[0];
            System.out.println(str.substring(1,str.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public RfidHandler(){}

    public void start(){
        if(running)
            return;
        //System.out.println("本地端口："+socket.getLocalPort());
        lastSendTime=System.currentTimeMillis();
        running=true;
        new Thread(new RfidHandler.KeepAliveWatchDog()).start();

    }

    class KeepAliveWatchDog implements Runnable{

        long checkDelay = 10;
        long keepAliveDelay = 2000;

        public void run() {
            while(running){
                if(System.currentTimeMillis()-lastSendTime>keepAliveDelay){
                    try {
                        try {
                            RfidHandler.this.startReader();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        RfidHandler.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                }else{
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        RfidHandler.this.stop();
                    }
                }
            }
        }
    }

    public void startReader() throws Exception{

        //02 08 B0 00 00 00 00 45
        byte[] buf = new byte[8];
        buf[0] = (byte) 0x02;
        buf[1] = (byte)0x08;
        buf[2] = (byte)0xB0;
        buf[3] = (byte) 0x00;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        CheckSum(buf,(byte) buf.length);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(buf);

        InputStream in = socket.getInputStream();
        System.out.println(in.available());
        if (in.available() == 0){
            System.out.println("null");
        }else {
            byte[] bytes = new byte[8];
            in.read(bytes);
            CheckSum(bytes,(byte)8);
            String str = toHex(bytes);
            //String[] str1 = str.split("");
            //ttoString(str1);
            System.out.println(str);
        }



        /*byte[] by2 = new byte[17];
        in.read(by2);
        String str2 = toHex(by2);
        String[] str4 = str2.split("");
        String[] str5 = new String[getInt(str4)];
        System.arraycopy(str4,0,str5,0,getInt(str4));
        if(getInt(str4)>3)
            System.out.println(ttoString(str5));
        set = new HashSet();
        set.add(ttoString(str5));
        list = new ArrayList(set);
        System.out.println(list);*/
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
