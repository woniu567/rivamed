package timming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *  SimpleDateFormat
 *  1、通过new 一个对象来操作对象，占用内存大,2、在并发量非常大的情况下，SimpleDateFormat是线程不安全的
 *
 *  Java 8开始，明确了日期时间概念，例如：瞬时（instant）、 长短（duration）、日期、时间、时区和周期
 *  使用LocalDate 代替Date，使用DateTimeFormatter 代替SimpleDateFormat
 *  关键类
 *  Instant：瞬时实例。
 *  LocalDate：本地日期，不包含具体时间 例如：2014-01-14 可以用来记录生日、纪念日、加盟日等。
 *  LocalTime：本地时间，不包含日期。
 *  LocalDateTime：组合了日期和时间，但不包含时差和时区信息。
 *  ZonedDateTime：最完整的日期时间，包含时区和相对UTC或格林威治的时差。
 */
public class DateTimeFormatterTest {

    public static void main(String[] args) {

        //年月日时分秒
        String DateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        //年月日
        //String DateNow = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        //时分秒
        //String DateNow = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(DateNow);
        System.out.println("--------------------------------------------------------");
        testStringT0LocalDate();
        System.out.println("--------------------------------------------------------");
        testLocalDateToString();
    }

    public static void testStringT0LocalDate(){

        // String --> LocalDate
        LocalDate localDate = LocalDate.parse("2019-12-07");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(LocalDate.parse("2019-10-09").format(pattern));
        System.out.println(localDate.format(pattern));
        System.out.println("-----------------------");
        // String --> LocalTime
        LocalTime localTime = LocalTime.parse("07:43:53");

        // String -->LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDate localDatee = LocalDate.parse("2019-12-07 07:43:53",formatter);

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDatee);
    }


    private static void testLocalDateToString() {
        System.out.println("------------1.localDate --> String-----------");
        //1.localDate --> String
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);    //yyyyMMdd
        String format2 = localDate.format(DateTimeFormatter.ISO_DATE);            //yyyy-MM-dd
        System.out.println(format1);
        System.out.println(format2);

        System.out.println("------------2.LocalTime  --> String-----------");
        //2.LocalTime  --> String
        LocalTime localTime = LocalTime.now();
        String format3 = localTime.format(DateTimeFormatter.ISO_TIME);            //20:19:22.42
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String format4 = localTime.format(formatter);
        System.out.println(format3);
        System.out.println(format4);

        System.out.println("------------LocalDateTime  --> String-----------");
        //3.LocalDateTime  --> String
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format5 = localDateTime.format(formatter2);
        System.out.println(format5);

    }
}
