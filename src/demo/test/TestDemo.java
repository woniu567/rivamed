package demo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDemo {

    public static void main(String[] args) {
        int a = 56;
        System.out.println(56/10);
        System.out.println(56%10);

        String string = String.format("DEVICE_%s_%s_%s","abcd","efgh","ijklmn");
        String str = String.format("DEVICE.%s.%s.%s","abcd","efgh","ijklmn");
        System.out.println(string);
        System.out.println(str);

        Date date = new Date();
        System.out.println(new SimpleDateFormat().format(date));

       /* Date now = new Date();
        Date before = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH,-3);
        before = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(before));
        System.out.println(sdf.format(now));*/

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.add(Calendar.MONTH,-3);
        System.out.println(sdf.format(calendar.getTime()));
    }
}
