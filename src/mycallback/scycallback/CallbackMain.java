package mycallback.scycallback;

public class CallbackMain {

    public static void main(String[] args) {

        TaxiDriver taxiDriver = new TaxiDriver();
        Passenger passenger = new Passenger();
        passenger.TaskTaxi(taxiDriver);
    }

}
