package mylistener.scylistener;

/*

Java中的事件监听是整个Java消息传递的基础和关键。牵涉到三类对象：事件源（EventSelf Source）、事件（EventSelf）、事件监听器（EventSelf Listener）。
　　事件源是事件发生的场所，通常就是各个组件，它可以是一个按钮，编辑框等。
　　事件监听者负责监听事件源所发生的事件，并对各种事件做出相应的响应。
　　事件是描述事件源状态改变的对象。
　　具体实现呢，可以看看Button的源码。可能不好看得懂。那好我们仿照侯捷先生的作法，来模拟一个这样的事件传递：
定义一个自己的事件
　　将事件源中value的最新值告知监听器

 */
public class MyEvent {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
