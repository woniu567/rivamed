package javaGetPath;

import java.io.File;
import java.io.IOException;

public class GetFilePath {

    public static void main(String[] args) {

        GetFilePath getFilePath = new GetFilePath();
        getFilePath.getPathOne();
        System.out.println();
        getFilePath.getPathTwo();
    }

    //方式一：System.getProperty()
    public void getPathOne(){
        //user.dir指定了当前的路径
        System.out.println(System.getProperty("user.dir") + "1");

        File directory = new File("");//设定为当前文件夹
        try {
            //获取当前的文件夹的标准路径
            System.out.println(directory.getCanonicalPath() + "2");

            //获取当前绝对路径
            System.out.println(directory.getAbsolutePath() + "3");

            File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "test.txt");
            System.out.println(file.toString());
        }catch (Exception e){

        }
    }

    /**
     * 方式二：
     * getCanonicalPath( ): 得到相对路径；相对路径：“."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹 ；
     * getAbsolutePath( ): 得到绝对路径；绝对路径： 则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径 ；
     * getPath( ): 得到的只是你在new File()时设定的路径 ；
     */
    public void getPathTwo(){
        File directory = new File("abc");
        try {
            System.out.println(directory.getCanonicalPath());
            System.out.println(directory.getAbsolutePath());
            System.out.println(directory.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
