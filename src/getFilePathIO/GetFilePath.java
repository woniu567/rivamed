package getFilePathIO;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GetFilePath {

    public static void main(String[] args) throws IOException {

        GetFilePath getFilePath = new GetFilePath();
        getFilePath.getPathOne();
        System.out.println("--------------------------------");
        getFilePath.getPathTwo();
        System.out.println("--------------------------------");
        getFilePath.getClassPath();
        System.out.println("--------------------------------");
        getFilePath.showUrl();

    }

    public void showUrl() throws IOException {
        //第一种：获取类加载的根路径
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);

        //获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        //第二种：获取项目路径
        File dir = new File("");
        String sourceFile = dir.getCanonicalPath();
        System.out.println(sourceFile);

        //
        URL url = this.getClass().getClassLoader().getResource("");
        System.out.println(url);

        //获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
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

    public void getClassPath(){
        //类的绝对路径
        System.out.println(Class.class.getClass().getResource("/").getPath());
        System.out.println(this.getClass().getResource("/").getPath());

        //得到工程的路径
        System.out.println(System.getProperty("user.dir"));
    }
}
