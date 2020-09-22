package getFilePathIO;


import java.io.*;

/**
 * IO练习，一个复制视频的类
 * 练习文件为大小8,684,470 字节的wmv视频文件
 * @author scy
 *
 */
public class CopyVideo {

    public static void main(String[] args) {
        String fromFileName = "F:\\my_profile\\20200302104224.mp4";
        String toFileName = "D:\\my_profile\\20200413163824.mp4";
        //baseCopyMethod(fromFileName,toFileName);
        //baseCopyMethod2(fromFileName,toFileName);
        //bufferedCopyMethod(fromFileName,toFileName);
        bufferedCopyMethod2(fromFileName,toFileName);
    }

    /**
     * 方法一：基础复制方法
     * 使用 InputStream，OutputStream
     * @param fromFileName
     * @param toFileName
     * 测试结果：38785毫秒
     */
    public static void baseCopyMethod(String fromFileName,String toFileName){
        long startTime = System.currentTimeMillis();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(fromFileName);
            out = new FileOutputStream(toFileName);
            int tempRead;
            while ((tempRead = in.read())>-1){
                out.write(tempRead);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileMethod(in,out);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一，基础复制耗时：" + (endTime-startTime) + "毫秒;");
    }

    /**
     * 使用InputStream，OutputStream，并增加字节数组作为缓冲区，提升效率
     * 增加缓存后复制用时：51毫秒
     * @param fromFileName
     * @param toFileName
     */
    public static void baseCopyMethod2(String fromFileName,String toFileName){
        long startTime = System.currentTimeMillis();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(fromFileName);
            out = new FileOutputStream(toFileName);
            byte[] buf = new byte[1024];//缓冲区数组，减少硬盘的读取操作
            int tempRead;
            while ((tempRead=in.read(buf))>-1){
                out.write(buf);
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileMethod(in,out);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法二，增加缓存后复制耗时：" + (endTime-startTime) + "毫秒");
    }

    /**
     * 使用BufferedInputStream和BufferedOutputStream后复制用时：21333毫秒
     * @param fromFileName
     * @param toFileName
     */
    public static void bufferedCopyMethod(String fromFileName,String toFileName){
        long startTime = System.currentTimeMillis();
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fromFileName));
            out = new BufferedOutputStream(new FileOutputStream(toFileName));
            int readContent;
            while ((readContent=in.read())!=-1){
                out.write(readContent);
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileMethod(in,out);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用BufferedInputStream和BufferedOutputStream后复制耗时：" + (endTime-startTime) + "毫秒");
    }

    /**
     * BufferedInputStream和BufferedOutputStream基础上添加缓存数组后复制耗时：46毫秒
     * @param fromFileName
     * @param toFileName
     */
    public static void bufferedCopyMethod2(String fromFileName,String toFileName){
        long startTime = System.currentTimeMillis();
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fromFileName));
            out = new BufferedOutputStream(new FileOutputStream(toFileName));
            byte[] buf = new byte[1024];//buf越大，耗时越少
            int tempContent;
            while ((tempContent=in.read(buf))!=-1){
                out.write(buf);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileMethod(in,out);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("BufferedInputStream和BufferedOutputStream基础上添加缓存数组后复制耗时：" + (endTime-startTime) + "毫秒");
    }

    public static void fileMethod(InputStream in,OutputStream out){
        try {
            if (in!=null){
                in.close();
            }
            if (out!=null){
                out.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
