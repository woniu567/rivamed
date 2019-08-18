package mycallback.callback.demo1;

public class Main implements InterfaceExample {

    public static void main(String[] args) {

        System.out.println("------接口使用测试--------");
        InterfaceTest test = new InterfaceTest();
        //调用InterfaceTest的handleThings方法，并传递Main的实例
        test.handleThings(new Main());
        System.out.println("------异步回调测试--------");
    }

    @Override
    public void sendMessage(String string) {       //重写接口方法
        System.out.println("接口回调成功"+string);
    }
}
