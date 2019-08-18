package schedulerdemo;

/*import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.web.context.WebApplicationContext;

public class ReceiveJobd implements Job{

    public void ReceiveJobd(){

    }
    //作业具体实现的功能
    public void execute(JobExecutionContext context) throws    JobExecutionException {
        try {
            //建立JobDataMap对象，用来接收传递的参数
            JobDataMap dataMap = context.getMergedJobDataMap();
            int ipLength = dataMap.getInt("ipLength");
            int tablenameLength = dataMap.getInt("tablenameLength");
            WebApplicationContext wc=(WebApplicationContext)dataMap.get("wcx");
            String ip = "";
            String tablename = "";
            for (int i = 0; i < ipLength; i++) {
                ip = dataMap.getString("ip" + i);
                for (int j = 0; j < tablenameLength; j++) {
                    tablename = dataMap.getString("tablename" + j);
                    ExchangeAccess ea=new ExchangeAccess(ip,tablename,wc);
                    //启动线程
                    ea.start();
                }
            }
            Scheduler scheduler = (Scheduler) dataMap.get("schedulerdemo");
            scheduler.deleteJob("ReceiveOnTimed", Scheduler.DEFAULT_GROUP);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}*/
