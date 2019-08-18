package mycallback.callback.proxy;

public class TestProxy {

    public static void main(String[] args) {

        ProxyManager proxyManager=new ProxyManager();
        proxyManager.setAgency(new ProxyRealWork());  //new ProxyRealWork 创建一个名叫小红的代理者
        proxyManager.doHomeWork(); //小明开始假装做作业，真正做作业的是小红
    }

}
