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
    }
}
