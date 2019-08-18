package mycallbacklistener.callback;

public interface Callback {

    boolean consider(int money);
    void payFor(int money);
}
