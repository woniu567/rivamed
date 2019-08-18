package mycallback.callbacklistener;

/**
 *  接口回调的拉模式，指的是，调用者自己主动获取甲方的信息。
 */

public class IndoorMan {

    GasListener gasListener;
    public void preparecook(){
        System.out.println("宅男:准备下厨做几个菜");
        System.out.println("宅男:进厨房，烧菜");
        System.out.println("宅男:刚开火，就发现煤气不足，没办法，只能打电话叫煤气公司");
        System.out.println("宅男:送一瓶煤气过来");
    }
    public void setListener(GasListener gasListener){
        this.gasListener = gasListener;
    }
    public void configureGas(){

        //主动获取甲方消息
        setListener(new GasListener() {
            @Override
            public void offerGas(String msg) {
                System.out.println("下单内容:" + msg);
            }
        });
    }
}



/*
再比如，使用线程Thread时，常常会在构建线程对象时，主动获取Runnable接口的实现。
public class Test
{
    public static void main(String[] args)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {

            }
        });
    }
}*/
