package mylistener.listeningmechanism.listenerdemo2;

/*
监听器接口
    当外部响应触发事件源上的事件时，产生一个事件对象，该事件对象会作为一个参数传递给监听器处理方法
 */
public interface EventListener {

    public void eventChange();
}
