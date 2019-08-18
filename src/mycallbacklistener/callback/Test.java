package mycallbacklistener.callback;

public class Test {

    public static void main(String[] args) {

        TaxiDriver taxiDriver = new TaxiDriver();
        Passenger passenger = new Passenger();
        passenger.taskTaxi(taxiDriver);
    }

}
