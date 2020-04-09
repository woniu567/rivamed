package demo;

import java.io.*;

public class FileWriteDemo {

    public static void main(String[] args) {
        FileWriteDemo fw = new FileWriteDemo();
        fw.fileWrite();
    }

    public void fileWrite(){
        File file = new File("D:/ceshi");
        if (!file.exists()){
            file.mkdir();
        }
        FileOutputStream  fos = null;
        try {
            fos = new FileOutputStream("D:/ceshi/1.txt",true);
            fos.write("ceshi".getBytes());
            fos.write("\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos != null){
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
