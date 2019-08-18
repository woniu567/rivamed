package mylistener.demo1;

public class Test {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.registerListener(new MyEventListener());
        eventSource.run();
        eventSource.eat();
    }
}
