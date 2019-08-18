package threadpool.threaddemo;

public class Sum {

    public Integer total=0;

    public void  sum() throws Exception{
        total=100;
        Thread.sleep(5000);
    }
}
