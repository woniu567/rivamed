package mylistener.scylistener;


/*

做一个监听器接口 Listener
　　当外部响应触发事件源上的事件时，产生一个事件对象，该事件对象会作为参数传递给监听器的事件处理方法

 */
public interface Listener {

    public void eventChanged(MyEvent event);
}
