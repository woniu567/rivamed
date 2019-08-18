package mynettynio.niodemo.demo1;

import java.nio.ByteBuffer;

public class NioDemo1 {

    public static void main(String[] args) {

        //初始化bytebuffer大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());//缓冲区正在操作的位置 默认从0开始。
        System.out.println(byteBuffer.capacity());//界面(缓冲区可用大小)
        System.out.println(byteBuffer.limit());   //缓冲区最大容量，一旦声明不能改变
        System.out.println("---------------------------往buffer里面存数据---------------------------");
        byteBuffer.put("dfoaifijykjdsrgref".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println("---------------------------读取里面的数据---------------------------");
        byteBuffer.flip();
        System.out.println("position:"+byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println("---------------------------重复读取数据-------------------------------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        byte[] bytes2 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes2);
        System.out.println(new String(bytes2,0,bytes2.length));
        System.out.println("-----------------------------清空缓冲区--------------------------------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println((char) byteBuffer.get());
    }
}
