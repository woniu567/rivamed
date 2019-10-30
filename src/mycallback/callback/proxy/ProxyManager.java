package mycallback.callback.proxy;


import org.junit.Test;

/**
 * Created by Administrator on 2017/12/21.
 * 创建一个代理的管理者，将要代理的任务分配给真正的处理任务的类，就是小明把自己的作业交给小红学霸做啦
 */
//被代理者（or 委托者）
public class ProxyManager implements ProxyWork{

    private ProxyWork proxyWork;

    /*
     * 这个方法是设置代理的方法，运用到了java 多态的思想
     * */
    public void setAgency(ProxyWork proxyWork){
        this.proxyWork=proxyWork;  // 这个方法是将真正的代理类（小红）作为参数传递给
    }

    @Override
    public void doHomeWork() {
        System.out.println("小明开始假装做作业");
        //其实小明没有做作业，而是叫来小红，让小红去做
        if(this.proxyWork!=null){ //先判断小红的引用是否传递过来
            proxyWork.doHomeWork(); //这里小红开始做作业，实施瞒天过海大计的关键一步
        }
        System.out.println("小明告诉妈妈，作业完成了");
    }

    /*
     * 开始测试代理，模拟一个场景
     *
     * */
    /*@TestCalendar
    public void client(){
        ProxyManager proxyManager=new ProxyManager();
        proxyManager.setAgency(new ProxyRealWork());  //new ProxyRealWork 创建一个名叫小红的代理者
        proxyManager.doHomeWork(); //小明开始假装做作业，真正做作业的是小红
    }*/

}
