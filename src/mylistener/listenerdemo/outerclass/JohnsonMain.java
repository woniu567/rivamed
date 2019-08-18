package mylistener.listenerdemo.outerclass;

import mylistener.listenerdemo.JohnsonEventSource;

//作为事件监听器的外部类
public class JohnsonMain {

    public static void main(String[] args) {
        exentTest();
    }

    public static void exentTest(){
        JohnsonEventSource source = new JohnsonEventSource();
        source.addEventListener(new OuterListerner());
        source.event1();
        source.event2();
        source.event3();
    }
}
