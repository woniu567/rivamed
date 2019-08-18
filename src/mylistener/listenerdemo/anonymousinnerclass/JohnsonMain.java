package mylistener.listenerdemo.anonymousinnerclass;


import mylistener.listenerdemo.JohnsonEventListener;
import mylistener.listenerdemo.JohnsonEventObject;
import mylistener.listenerdemo.JohnsonEventSource;

public class JohnsonMain {

    public static void main(String[] args) {
        eventTest();
    }

    /**
     *  匿名方式实现监听
     */
    public static void eventTest(){
        System.out.println("匿名方式实现监听");
        //定义事件源
        JohnsonEventSource source = new JohnsonEventSource();
        //事件源绑定事件监听1，这里使用匿名方式实现监听
        source.addEventListener(new JohnsonEventListener() {
            @Override
            public void onAction(JohnsonEventObject eventObject) {
                JohnsonEventSource source1 = (JohnsonEventSource) eventObject.getSource();
                source1.sourceFunction("事件监听器1,监听到事件,事件类型：" + String.valueOf(eventObject));
                //这里也可以直接使用外部的source对象，本质上是一个对象
            }
        });
        //事件源绑定事件监听2
        source.addEventListener(new JohnsonEventListener() {
            @Override
            public void onAction(JohnsonEventObject eventObject) {
                JohnsonEventSource source2 = (JohnsonEventSource) eventObject.getSource();
                source2.sourceFunction("事件监听器1,监听到事件,事件类型：" + String.valueOf(eventObject));
                //这里也可以直接使用外部的source对象，本质上是一个对象
            }
        });
        //启动事件
        source.event1();
        source.event2();
        source.event3();
    }
}




















