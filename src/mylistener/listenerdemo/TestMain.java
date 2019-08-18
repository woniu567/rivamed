package mylistener.listenerdemo;

/**
 *
 *  自身类作为事件监听器
 */
public class TestMain implements JohnsonEventListener{

    @Override
    public void onAction(JohnsonEventObject eventObject){
        JohnsonEventSource source = (JohnsonEventSource) eventObject.getSource();
        source.sourceFunction("事件监听器，监听到事件，事件类型："+String.valueOf(eventObject.getEventType()));
    }

    public static void main(String[] args){
        JohnsonEventSource source = new JohnsonEventSource();
        source.addEventListener(new TestMain());
        source.event1();
        source.event2();
        source.event3();
    }
}










