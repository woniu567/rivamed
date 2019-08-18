package mycallbacklistener.listener;

public class Event {

    public EventSource getEventSource() {
        return eventSource;
    }

    public void setEventSource(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    private EventSource eventSource;
    public Event(){

    }

    public Event(EventSource eventSource){
        this.eventSource = eventSource;
    }


}
