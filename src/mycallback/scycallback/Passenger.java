package mycallback.scycallback;

public class Passenger implements Callback{            //回调方类A

    @Override
    public boolean Consider(int money) {

        boolean result = true;
        if(money>80){
            System.out.println("太贵了，能便宜点吗？");
            result = false;
        }
        return result;
    }

    @Override
    public void PayFor(int money) {

        System.out.println("您好！这是您的钱："+money);
    }

    public void TaskTaxi(TaxiDriver td){                //询问多少钱，就是方法a

        System.out.println("师傅去一天多少钱？");
        td.Answer(this);
    }
}
