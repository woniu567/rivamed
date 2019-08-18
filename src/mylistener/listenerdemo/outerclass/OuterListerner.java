package mylistener.listenerdemo.outerclass;

import mylistener.listenerdemo.JohnsonEventListener;
import mylistener.listenerdemo.JohnsonEventObject;
import mylistener.listenerdemo.JohnsonEventSource;

//作为事件监听器的外部类
public class OuterListerner implements JohnsonEventListener {

    @Override
    public void onAction(JohnsonEventObject eventObject) {
        JohnsonEventSource source = new JohnsonEventSource();
        source.sourceFunction("事件监听器，监听到事件，事件类型："+String.valueOf(eventObject.getEventType()));
    }
}
