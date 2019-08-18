package timerdemo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Mytask{

    private static Timer timer = new Timer();

    public static void main(String[] args) {

        /*SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startTime = null;
        try {
            startTime = new SimpleDateFormat("HH:mm:ss").parse(sdf.format(System.currentTimeMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("zhi xing yan shi ren wu!");
            }
        },startTime,2000);*/

        /*ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);*/


        /*SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startTime = null;
        try {
            startTime = new SimpleDateFormat("HH:mm:ss").parse(sdf.format(System.currentTimeMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("zhi xing yan shi ren wu!");
            }
        },2000);*/


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("zhi xing ding shi ren wu yi ci !!!");
            }
        },5000);
    }
}
