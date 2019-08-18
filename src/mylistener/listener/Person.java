package mylistener.listener;
/*
1.原理：
　　当范围对象的状态发生变化的时候，服务器自动调用监听器对象中的方法。
    例如：创建一个“人”类Class Person
    人拥有吃的方法public void eat(){},我们的目的就是，在这个人吃之前要提醒他洗手，所以我们就要监听这个人，
    不管他在什么时候吃，我们都要能够监听到并且提醒他洗手，通俗点讲这个就是监听器的作用(在吃之前提醒他洗手)。

2.组成：
　　 2.1 Java的时间监听机制涉及到三个组件：事件源、事件监听器、事件对象

　　 2.2 当事件源上发生操作时，它会调用事件监听器的一个方法，并且调用这个方法时，会传递事件对象过来

　　 2.3 事件监听器是由开发人员编写，开发人员在事件监听器中，通过事件对象可以拿到事件源，从而对事件源上的操作进行处理

3.实现：

　　3.1 创建一个人类，人具有跑、吃的方法　　（创建一个事件源）

　　3.2 创建一个接口用来监视人的跑、吃　　　（事件监听器）

　　3.3 创建一个事件对象，里面用来封装人(Person)这个对象　　（事件对象）

　　3.4 创建一个测试类，用来测试Java监听机制
 */

public class Person {

    //1.1首先定义一个私有的、空的监听器对象，用来接收传递进来的事件监听器(相当于一个全局变量)
    private PersonListener listener;
    //1.2将传递进来的事件监听器付给1.1中的listener
    public void registerListener(PersonListener personListener){
        this.listener=personListener;
    }
    //1.3判断listener是否为null，如果不为空，则执行监听器中的方法,否则照常调用
    public void run(){
        if(listener!=null){
            Even even=new Even(this);
            this.listener.dorun(even);
        }
        System.out.println("人具有跑的方法");
    }
    //1.4和1.3一个道理
    public void eat(){
        if(listener!=null){
            Even even=new Even(this);
            this.listener.doeat(even);
        }
        System.out.println("人具有吃的方法");
    }
}
