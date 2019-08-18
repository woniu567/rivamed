package demo.test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("测试汉字乱码！！");

        Calendar now = Calendar.getInstance();
        int a = now.get(Calendar.YEAR);
        int b = now.get(Calendar.MONTH) + 1;
        int c = now.get(Calendar.DAY_OF_MONTH);
        int d = now.get(Calendar.HOUR_OF_DAY);
        int e = now.get(Calendar.MINUTE);
        int f = now.get(Calendar.SECOND);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(System.currentTimeMillis()));*/
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        show();
    }

    public static void show(){
        try {
            Thread.sleep(2000);
            System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
