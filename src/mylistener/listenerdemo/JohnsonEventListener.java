package mylistener.listenerdemo;

import java.util.EventListener;


/**
 *  事件监听器定义了一个接口，用来规范事件发生之后事件源调用的处理方法
 *  事件监听器是一个接口，里面定义了一个固定名字的响应方法，用来提供给事件源调用。
 *  注册事件监听器就是实现监听器接口的响应方法并添加到事件源的监听器集合中。
 */
public interface JohnsonEventListener extends EventListener {

    public void onAction(JohnsonEventObject eventObject);
}
