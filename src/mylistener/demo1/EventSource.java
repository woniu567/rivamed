package mylistener.demo1;

public class EventSource {

    private EventListener eventListener;

    public void run(){
        if (eventListener!=null){
            EventSelf eventSelf = new EventSelf();
            eventListener.doRun(eventSelf);
        }
        System.out.println("要跑！");
    }

    public void eat(){
        if (eventListener!=null){
            EventSelf eventSelf = new EventSelf();
            eventListener.doEat(eventSelf);
        }
        System.out.println("要吃！");
    }

    public void registerListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
}
