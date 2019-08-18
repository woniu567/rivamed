package demo.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DayInterval implements ServletContextListener {

    public static void showDayTime() {
        Date sendDate = new Date();
        Timer dTimer = new Timer();
        dTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minutes = c.get(Calendar.MINUTE);
                if (hour == 11 && minutes == 33) {
                    // 每天执行，若为11:38
                    System.out.println("mei ri ding shi ren wu zhi xing,每日任务已经执行!!!");
                }
            }
        }, sendDate, 24 * 60 * 60 * 1000);//设置24小时执行一次
    }

    public static void main(String[] args) {
        //showDayTime();
        showDayTime2();
    }

    public static void showDayTime2() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, 13, 20, 00);
        //设置要执行的日期时间
        Date defaultdate = calendar.getTime();
        Timer dTimer = new Timer();
        dTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("mei ri ding shi ren wu zhi xing,每日任务已经执行");
            }
        }, defaultdate, 24 * 60 * 60 * 1000);//24* 60* 60 * 1000
    }

    //每月定时执行
    public static void showMonthTime() {
        Date sendDate = new Date();
        Timer dTimer = new Timer();
        dTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                if (day == 30) {
                    // 每天执行，若为每月30号才执行
                    System.out.println("每月定时任务已执行");
                }
            }
        }, sendDate, 24 * 60 * 60 * 1000);//24* 60* 60 * 1000
    }


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
