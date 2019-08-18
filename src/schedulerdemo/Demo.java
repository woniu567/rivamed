package schedulerdemo;

public class Demo {


    public static void main(String[] args) {

    }

    /*//设置定时作业
    public void startScheduler(HttpServletRequest requests)throws SchedulerException{
        try{
            //建立作业调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //判断作业调度内是否有作业，如果有将其删除
            if (!scheduler.isShutdown()) {
                scheduler.deleteJob("ReceiveOnTimed", Scheduler.DEFAULT_GROUP);
            }
            //删除调度器的作业后，新建一个我们现在要完成的作业，该作业所需要的类是ReceiveJobd.class,作业名字是ReceiveOnTimes,所属分组是Scheduler.DEFAULT_GROUP
            JobDetail jobDetail = new JobDetail("ReceiveOnTimed", Scheduler.DEFAULT_GROUP, ReceiveJobd.class);
            int m = ips.length;
            int n = tablenames.length;
            //向作业内设置要传入的参数
            jobDetail.getJobDataMap().put("schedulerdemo", scheduler);
            jobDetail.getJobDataMap().put("ipLength", m);
            jobDetail.getJobDataMap().put("tablenameLength", n);
            jobDetail.getJobDataMap().put("wcx",wc);
            for (int i = 0; i < m; i++) {
                jobDetail.getJobDataMap().put("ip" + i, ips[i]);
                for (int j = 0; j < n; j++) {
                    jobDetail.getJobDataMap().put("tablename" + j, tablenames[j]);
                }
            }
            //建立触发器，判断何时触发该作业,参数为触发器的名称，触发器分组，作业名称，作业分组，时间设定
            Trigger trigger = new CronTrigger("ReceiverOnTimeTriggerd", scheduler.DEFAULT_GROUP, "ReceiveOnTimed", scheduler.DEFAULT_GROUP, time);
            //将作业和触发器添加到调度器
            scheduler.scheduleJob(jobDetail, trigger);
            //按照设置开始调度
            scheduler.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/

}
