package mycallback.callback.demo1;

public class InterfaceTest {

    public void handleThings(InterfaceExample example){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("做一些事....");
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                example.sendMessage("接口传的函数");//回调接口函数
            }
        }).start();
    }
}
