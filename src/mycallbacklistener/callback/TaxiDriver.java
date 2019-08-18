package mycallbacklistener.callback;

public class TaxiDriver {

    public int answer(Callback callback){
        System.out.println("路费需要100元");
        if (callback.consider(100) == true){
            callback.payFor(100);
        }
        return 100;
    }
}
