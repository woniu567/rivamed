package mycallback.callbacklistener;

//接口回调的推模式，指的是，甲方主动将其地址推送给调用者。比如本例：
public interface GasListener {

    public void offerGas(String msg);
}
