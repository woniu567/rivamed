package mylistener.listenerdemo;

import java.util.EventObject;

/**
 *  事件监听是Java事件机制的实现，Java事件机制的三个基本组成成分
 *  1、事件对象：通常继承自Java.util.EventObject的对象，一般用来判断事件类型的作用
 *  2、事件源：触发事件的源头，在GUI和Swing编程中，如Button按钮等对象就是一个事件源
 *  3、事件监听器：负责监听事件源发出的事件并作出响应动作的对象，通常实现java.util.EventListener
 *
 *  事件的一般流程：
 *  1、事件源注册监听器
 *  2、事件发生，事件源向监听器发送事件对象
 *  3、监听器对象响应事件
 */

/**
 *  JohnsonEventObject是一个事件对象
 *  自己理解事件对象的作用：
 *    （1）事件对象储存了事件源对象，当事件监听器方法进行处理程序的时候，如果需要改变事件源的属性值等等操作时候，
 *         就可以通过事件对象获取到事件源对象，从而对事件事件源的属性进行修改或者调用事件源的方法。
 *    （2）继承了java.util.EventObject之后的自定义事件对象，可以添加其他属性，比如说事件类型等等，添加一些必要的业务属性等。
 *
 *  当事件发生后，事件监听器的响应方法会接受到事件对象（作为方法参数被传递），事件对象中的事件源属性可以提供数据源对象
 *  供响应方法调用，从而改变事件源的属性等。
 */
public class JohnsonEventObject extends EventObject {


    public static int EVENT_TYPE_ONE = 1;
    public static int EVENT_TYPE_TWO = 2;
    public static int EVENT_TYPE_THREE = 3;
    private int eventType;

    //source 是事件源
    public JohnsonEventObject(Object source){
        super(source);
    }

    public JohnsonEventObject(Object source,int eventType){
        super(source);
        this.eventType = eventType;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getEventType(){
        return eventType;
    }

    public void setEventType(int eventType){
        this.eventType = eventType;
    }
}
















