package my_tcp_udp.tcpjihedemo;

import java.io.*;

public class peizhiip {

    public static void main(String[] args) throws IOException {

        File file = new File("/home/data/my.txt");
        //File file = new File("D:\\ipconfig.txt");
        String lineTxt = null;
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((lineTxt = bufferedReader.readLine()) != null){
                System.out.println(lineTxt);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
