package getPathIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WriteFile {

    public static void main(String[] args) {

        WriteFile wf = new WriteFile();
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                wf.writeMethod("fsadftretetgtererfgsfgsdfgs");
                System.out.println("延时3s后每3s一次...");
            }
        },3,3,TimeUnit.SECONDS);
        /*ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                wf.writeMethod("fsadftretetgtererfgsfgsdfgs");
                System.out.println("每3s一次...");
            }
        },3,3,TimeUnit.SECONDS);*/
    }

    //往已有的文件下面追加内容
    public void writeMethod(String string){
        File file = new File("D:/ceshi/");
        FileOutputStream fos = null;
        if (!file.exists()){
            file.mkdir();//创建文件夹，创建文件file.createNewFile()
        }
        try {
            fos = new FileOutputStream("D:/ceshi/" + "55" + ".txt",true);
            for (int i = 0; i < 10; i++) {
                fos.write((string + "\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
