package mycallbacklistener.callbacklistener;

public class TestMain {

    public static void main(String[] args) {

        /*Manager manager = new Manager();
        EventCallback eventCallback = new EventCallback();
        eventCallback.askManager(manager);*/
        EventCallback eventCallback = new EventCallback();
        Manager.getManager().registerCallback(new Callback() {
            @Override
            public boolean onRun() {
                System.out.println("跑步之前热身了吗？");
                return true;
            }

            @Override
            public boolean onEat() {
                System.out.println("吃饭之前洗手了吗？");
                return true;
            }
        });
        Manager.getManager().answer(eventCallback);
    }
}
