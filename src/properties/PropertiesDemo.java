package properties;

import java.io.*;

public class PropertiesDemo {

    private static String ip1 = null;
    private static String ip2 = null;

    public static void main(String[] args) throws Exception{



        try {
            String inputStream = ("D:/ip.txt");
            String str = null;
            File file = new File(inputStream);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int line = 1;
            while ((str = reader.readLine())!=null){
                //System.out.println(str);
                //line ++;
                if (line == 1){
                    ip1 = str;
                    line ++;
                    //System.out.println(ip1);
                }else{
                    ip2 = str;
                    //System.out.println(ip2);
                }

            }
            //reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(ip1);
        System.out.println(ip1);
        System.out.println(ip2);
    }



}
