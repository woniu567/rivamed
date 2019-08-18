package mylistener.listenerdemo;


import java.util.HashSet;
import java.util.Set;

/**
 *   事件源类
 *   事件源是事件发生的地方，是事件触发的源头，事件监听器注册的地方。
 *
 *   事件源是事件触发的地方，其中有一个事件监听器集合，通过addEventListener方法可以添加事件监听器到监听器集合中，也就是经常说的“注册事件监听器”。
 *   其中的doOnAction方法是必不可少的一个操作，即在事件发生之后遍历监听器集合，执行监听器定义的动作响应方法。
 *   event1，event2，event3是定义的三个事件方法，模拟事件的发生，发生事件之后程序需要实例化事件对象（事件对象
 *   储存了事件源即本对象的引用），并将其作为参数依次调用每个监听器的动作响应方法，即上面的步骤。
 */
public class JohnsonEventSource {

    //事件监听器的集合:事件源中存储一个监听器集合，当事件发生之后，事件源会依次调用，每个监听器的响应方法
    private Set<JohnsonEventListener> eventListeners = new HashSet<JohnsonEventListener>();

    //注册监听器：添加监听器
    public void addEventListener(JohnsonEventListener eventListener){
        if (eventListener!=null){
            eventListeners.add(eventListener);
        }
    }

    //注销监听器：把这个监听器去掉
    public boolean removeEventListener(JohnsonEventListener eventListener){
        return eventListeners.remove(eventListener);
    }

    //发生事件一：发生事件需要外部调用
    public void event1(){
        JohnsonEventObject object = new JohnsonEventObject(this,JohnsonEventObject.EVENT_TYPE_ONE);
        doOnAction(object);
    }

    //发生事件二：发生事件方法需要外部调用
    public void event2(){
        JohnsonEventObject object = new JohnsonEventObject(this,JohnsonEventObject.EVENT_TYPE_TWO);
        doOnAction(object);
    }

    //发生事件三：发生事件方法需要外部调用
    public void event3(){
        JohnsonEventObject object = new JohnsonEventObject(this,JohnsonEventObject.EVENT_TYPE_THREE);
        doOnAction(object);
    }

    //遍历监听器执行响应方法
    private void doOnAction(JohnsonEventObject eventObject){
        for (JohnsonEventListener listener : eventListeners){
            listener.onAction(eventObject);
        }
    }

    //定义一个事件源方法
    public void sourceFunction(String message){
        System.out.println(message);
    }

}


















