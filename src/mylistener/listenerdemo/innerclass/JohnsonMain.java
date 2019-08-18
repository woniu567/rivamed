package mylistener.listenerdemo.innerclass;

import mylistener.listenerdemo.JohnsonEventListener;
import mylistener.listenerdemo.JohnsonEventObject;
import mylistener.listenerdemo.JohnsonEventSource;


//内部类作为事件监听器
public class JohnsonMain {

    public static void main(String args[]) {
        eventTest();
    }

    /**
     * 定义监听器类实现接口方式
     */
    public static void eventTest() {
        System.out.println("定义监听器类实现接口方式实现监听");
        JohnsonEventSource source = new JohnsonEventSource();
        // 事件源绑定事件监听1
        source.addEventListener(new ExampleListener(1));
        // 事件源绑定事件监听2
        source.addEventListener(new ExampleListener(2));
        // 启动事件
        source.event1();
        source.event2();
        source.event3();
    }

    public static class ExampleListener implements JohnsonEventListener {
        private int number;

        public ExampleListener(int number) {
            this.number = number;
        }

        public void onAction(JohnsonEventObject eventObject) {
            JohnsonEventSource source = (JohnsonEventSource) eventObject.getSource();
            source.sourceFunction("事件监听器 " + number + " 监听到事件--事件类型: " + String.valueOf(eventObject.getEventType()));
        }
    }
}







