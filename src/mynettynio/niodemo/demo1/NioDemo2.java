package mynettynio.niodemo.demo1;

import java.nio.ByteBuffer;

public class NioDemo2 {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        String str = "duiafdfj";
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();//开启读的模式
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        byteBuffer.mark();//打印标记
        System.out.println(byteBuffer.mark());
        System.out.println(new String(bytes,0,2));
        System.out.println(byteBuffer.position());
        System.out.println("--------------------------------------------------");
        //byteBuffer.reset();//还原到mark位置
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes,2,2));
        //System.out.println(new String(bytes,0,2));
        System.out.println("--------------------------------------------------");
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
    }
}
