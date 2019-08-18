package mynettynio.niodemo.demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo3 {

    //直接缓冲区读写
    /*public static void main(String[] args) throws Exception{

        long statTime=System.currentTimeMillis();
        //创建管道
        FileChannel inChannel=	FileChannel.open(Paths.get("f://1.mp4"), StandardOpenOption.READ,StandardOpenOption.WRITE);
        FileChannel   outChannel=	FileChannel.open(Paths.get("f://2.mp4"), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //定义映射文件
        MappedByteBuffer inMappedByte = inChannel.map(FileChannel.MapMode.READ_ONLY,0, inChannel.size());
        MappedByteBuffer outMappedByte = outChannel.map(FileChannel.MapMode.READ_WRITE,0, inChannel.size());
        //直接对缓冲区操作
        byte[] dsf=new byte[inMappedByte.limit()];
        inMappedByte.get(dsf);
        outMappedByte.put(dsf);
        inChannel.close();
        outChannel.close();
        long endTime=System.currentTimeMillis();
        System.out.println("操作直接缓冲区耗时时间:"+(endTime-statTime));
    }*/

    //非直接缓冲区读写
    public static void main(String[] args) throws Exception{

        long startTime = System.currentTimeMillis();

        //读入流
        FileInputStream fileInputStream = new FileInputStream("D://testimg/1.mp4");
        //写入流
        FileOutputStream fileOutputStream = new FileOutputStream("D://testimg/2.mp4");

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (inChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        outChannel.close();
        inChannel.close();
        fileOutputStream.close();
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime));

    }

}
