package mycallbacklistener.callback;

public class Passenger implements Callback{

    @Override
    public boolean consider(int money) {
        boolean result = true;
        if (money > 80){
            System.out.println("太贵了，能便宜点吗？");
            return !result;
        }
        return result;
    }

    @Override
    public void payFor(int money) {
        System.out.println("给这是路费！");
    }

    public void taskTaxi(TaxiDriver taxiDriver){
        System.out.println("师傅，我想去...请问路费多少钱？");
        taxiDriver.answer(this);
    }
}
