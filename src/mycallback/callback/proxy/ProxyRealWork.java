package mycallback.callback.proxy;

/**
 * 代理模式和回调模式的区别：
 * 　　本人认为两者是相同的，都是同一种思想（自己的事情交给别人做，自己发出命令），若更加严格的区分，
 *     也是两种思想（一个强调代理，一个强调回调），若要真的找不同，那就从他们具体的实现方式
 *     （代理模式：追求主题的统一，发出命令，各谋其事；回调机制：追求通知，发出命令，接受通知）
 *
 * 注释：本文中的代理模式是静态代理，耦合性很高，在项目中可能很少用，所以项目中要开发通用的代理就要利用反射机制，实现动态代理。
 * （例如 小红 要帮小明，小张，小王三个人写作业，他们的作业本的要分别对应他们三个人，不能只对应某个人）
 */
//代理者
public class ProxyRealWork implements ProxyWork{

    private ProxyWork proxyWork;   //将被代理者，也就是游戏小王子小明传递过来，其实也就是java 的多态

    //这里传入被代理者，用到了多态
    public void setAgency(ProxyWork proxyWork){   //这里将会传入实例化的小明
        this.proxyWork=proxyWork;
    }


    /*
        这个代理者是真正做作业的人，也即是小红这个学霸
     */
    @Override
    public void doHomeWork() {
        this.before();
        //这个位置也就是相当于Spring Aop 切点的位置service 层
        System.out.println("                     真正的任务执行者，正在执行任务，也就是小红做作业啦");
        this.after();
    }

    /*
     * 这里的预处理和善后处理类似于Spring的面向切面编程，具体的实现有事务管理，日志等
     * */

    //预处理动作
    private void before(){
        //TODO
        System.out.println("                 小红预温习了功课，然后开始做作业");
    }

    //善后处理
    private void after(){
        //TODO
        System.out.println("                   小红把做完的作业又检查了一遍，不能做的全对，不然太假了");
    }

}
