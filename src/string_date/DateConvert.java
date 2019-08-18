package string_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println(date.toString());
        //dateToSimpleDateFormat();
    }

    public static void simpleDateFormatToDate(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date指定格式：yyyy-MM-dd HH:mm:ss:SSS
        String string = simpleDateFormat.format(System.currentTimeMillis());//format()方法将Date转换成指定格式的String
        try {
            date = simpleDateFormat.parse(string);//调用parse()方法时 注意 传入的格式必须符合simpleDateFormat对象的格式，即"yyyy-MM-dd HH:mm:ss:SSS" 否则会报错！！
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());
    }

    public static void date2SimpleDateFormat(){
        // 使用format()方法将日期转换为指定格式的文本
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 创建Date对象，表示当前时间
        Date  now = new Date();

        // 调用format()方法，将日期转换为字符串并输出
        System.out.println(sdf1.format(now));
        System.out.println(sdf2.format(now));
        System.out.println(sdf3.format(now));

        // 使用parse()方法将文本转换为日期
        String d = "2014-6-1 21:05:36";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 调用parse()方法，将字符串转换为日期
        Date date = null;
        try {
            date = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
    }

    public static void dateToSimpleDateFormat(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
