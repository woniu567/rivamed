package timerdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerRun {

    public void timerRun() {
        // 一天的毫秒数
        long daySpan = 5000;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Date startTime = new SimpleDateFormat("HH:mm:ss").parse(sdf.format(System.currentTimeMillis()));
            Timer t = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.print("定时任务" + "sdfsfewtgew ");
                }
            };

            t.schedule(task,startTime,daySpan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TimerRun().timerRun();
    }
}
