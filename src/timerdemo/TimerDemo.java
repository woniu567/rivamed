package timerdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    private static Timer timer = new Timer();
    private static long time = 5000;

    public static void main(String[] args) {

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("zhixing yanshi!");
            }
        },time);*/
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
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
        },startTime,2000);

    }
}
