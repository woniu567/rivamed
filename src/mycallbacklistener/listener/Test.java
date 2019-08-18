package mycallbacklistener.listener;

public class Test {

    public static void main(String[] args) {

        EventSource eventSource = new EventSource();
        eventSource.registerListener(new MyEventListener());
        eventSource.eat();
        eventSource.run();
    }

     static class MyEventListener implements EventListener{

        @Override
        public void doRun(Event event) {
            System.out.println("跑步之前要热身...");
        }

        @Override
        public void doEat(Event event) {
            System.out.println("吃饭之前要洗手...");
        }
    }
}
