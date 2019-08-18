package cn.rivamed;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientHandler {

    private String serverIp = "192.168.100.14";
    private int port = 20108;
    private static  Socket socket;
    private boolean running=false;
    private long lastSendTime;
    private Set set;


    public ClientHandler(){}

    public ClientHandler(String serverIp, int port) {
        this.serverIp=serverIp;
        this.port=port;
    }

    public static void getDeviceID(){

        byte[] bytes = new byte[4];
        bytes[0] = DataProtocal.BEGIN_SOF;
        bytes[1] = DataProtocal.LEN_1;
        bytes[2] = DataProtocal.CMD_UID;
        bytes[3] = DataProtocal.END;

        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            InputStream in1 = socket.getInputStream();
            byte[] by1 = new byte[20];
            in1.read(by1);
            String str1 = toHex(by1);
            String[] str = str1.split("");
            String[] str3 = new String[getInt(str)];
            System.arraycopy(str,0,str3,0,getInt(str));
            System.out.println(ttoString(str3));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws UnknownHostException, IOException {
        if(running)
            return;
        socket = new Socket(serverIp,port);
        //System.out.println("本地端口："+socket.getLocalPort());
        lastSendTime=System.currentTimeMillis();
        running=true;
        System.out.print("设备ID: ");
        ClientHandler.getDeviceID();
        try {
            Thread.sleep(1000);
            new Thread(new KeepAliveWatchDog()).start();
        }catch (Exception e){

        }
    }

    class KeepAliveWatchDog implements Runnable{

        long checkDelay = 10;
        long keepAliveDelay = 2000;

        public void run() {
            while(running){
                if(System.currentTimeMillis()-lastSendTime>keepAliveDelay){
                    try {
                        try {
                            System.out.print(new KeepAlive() + " EPC: ");
                            ClientHandler.this.startReader();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ClientHandler.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                }else{
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        ClientHandler.this.stop();
                    }
                }
            }
        }
    }

    public void startReader() throws Exception{

        byte[] buf = new byte[4];
        /*buf[0] = (byte) 0xaa;
        buf[1] = (byte) 0x02;
        buf[2] = (byte) 0x18;
        buf[3] = (byte) 0x55;*/
        buf[0] = DataProtocal.BEGIN_SOF;
        buf[1] = DataProtocal.LEN_1;
        buf[2] = DataProtocal.CMD_INVENTORY;
        buf[3] = DataProtocal.END;
        /*byte[] data = new byte[]{};
        buf = DataProtocal.PiceComment(DataProtocal.CMD_INVENTORY,data);*/

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(buf);
        InputStream in2 = socket.getInputStream();
        byte[] by2 = new byte[17];
        in2.read(by2);
        String str2 = toHex(by2);
        String[] str4 = str2.split("");
        String[] str5 = new String[getInt(str4)];
        System.arraycopy(str4,0,str5,0,getInt(str4));
        if(getInt(str4)>3)
        System.out.println(ttoString(str5));
        set = new HashSet();
        set.add(ttoString(str5));
        /*list = new ArrayList(set);
        System.out.println(list);*/
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
