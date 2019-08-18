package mycallback.scycallback;

public class TaxiDriver {

    public int Answer(Callback callback){

        System.out.println("路费需要100");

        if (callback.Consider(100)==true){
            callback.PayFor(100);
        }

        return 100;
    }

}
