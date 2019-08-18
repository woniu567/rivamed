package mycallbacklistener.callbacklistener;

public class Manager {

    private Callback callback;
    EventSource eventSource = new EventSource();

    public Manager(){}

    private static Manager manager;

    public static synchronized Manager getManager(){
        if (manager == null){
            manager = new Manager();
        }
        return manager;
    }


    public void answer(Callback callback){

        eventSource.registerListener(new MyListener());
        if (callback.onRun() == true){
            eventSource.run();
        }

        if (callback.onEat()){
            eventSource.eat();
        }
    }

    public void registerCallback(Callback callback){
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
