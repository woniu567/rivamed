package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo2 {

    private static Timer timer = new Timer();
    private static long time = 5000;

    public static void main(String[] args) {

        /*int ii = 2683;
        int aa = ii%256;
        int a = ii/256;
        System.out.println(a);*/

        /*String string = "dfadfawef";
        System.out.println(string);*/
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
                System.out.println("ding shi ren wu zhi xing!");
            }
        },startTime,time);
    }
}
