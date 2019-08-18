package demo.test;

import demo.TransferUtils;

import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        byte[] data = new byte[1];
        int a = calendar.get(Calendar.YEAR)-2000;
        int b = calendar.get(Calendar.MONTH) + 1;
        int c = calendar.get(Calendar.DAY_OF_MONTH);
        int d = calendar.get(Calendar.HOUR_OF_DAY);
        int e = calendar.get(Calendar.MINUTE);
        int f = calendar.get(Calendar.SECOND);

        data[0] = (byte) (a & 0xff);

        System.out.println(TransferUtils.Byte2String(data));

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " ");
    }
}
