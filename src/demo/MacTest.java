package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacTest {

    public static void main(String[] args) throws Exception{

        //获取设备IP
        /*InetAddress ip;
        ip = InetAddress.getLocalHost();
        System.out.println("Current IP address : " + ip.getHostAddress());
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        byte[] mac = network.getHardwareAddress();
        System.out.print("Current MAC address : ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        System.out.println(sb.toString());*/


        //获取本机MAC
        /*try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c ipconfig /all");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("Physical Address") > 0) {
                    int index = line.indexOf(":");
                    index += 2;
                    String address = line.substring(index);
                    System.out.println(address);
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        //获取局域网内设备MAC
        String string = getMacAddress("192.168.111.172");
        System.out.println(string);

    }


    public static String command(String cmd) throws Exception{
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        InputStream in = process.getInputStream();
        StringBuilder result = new StringBuilder();
        byte[] data = new byte[256];
        while(in.read(data) != -1){
            String encoding = System.getProperty("sun.jnu.encoding");
            result.append(new String(data,encoding));
        }
        return result.toString();
    }


    /**
     * 获取mac地址
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getMacAddress(String ip) throws Exception{
        String result = command("ping "+ip+" -n 2");
        if(result.contains("TTL")){
            result = command("arp -a "+ip);
        }
        String regExp = "([0-9A-Fa-f]{2})([-:][0-9A-Fa-f]{2}){5}";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(result);
        StringBuilder mac = new StringBuilder();
        while (matcher.find()) {
            String temp = matcher.group();
            mac.append(temp);
        }
        return mac.toString();
    }
}
