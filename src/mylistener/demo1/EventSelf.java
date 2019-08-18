package mylistener.demo1;

public class EventSelf {

    private EventSource eventSource;

    public EventSelf(){

    }

    public EventSelf(EventSource eventSource){
        this.eventSource = eventSource;
    }

    public EventSource getEventSource() {
        return eventSource;
    }

    public void setEventSource(EventSource eventSource) {
        this.eventSource = eventSource;
    }
}


