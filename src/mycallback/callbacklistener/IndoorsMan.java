package mycallback.callbacklistener;

/**
 *  接口回调的推模式，指的是，甲方主动将其地址推送给调用者。
 */
public class IndoorsMan {

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

}









