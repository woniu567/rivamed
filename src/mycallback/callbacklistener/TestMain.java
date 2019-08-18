package mycallback.callbacklistener;

public class TestMain {

    public static void main(String[] args) {

        IndoorsMan indoorsMan = new IndoorsMan();
        GasCompany gasCompany = new GasCompany();

        gasCompany.advertiseTo(indoorsMan);
        indoorsMan.preparecook();
        //gasCompany.offerGas("5555555");

        IndoorMan indoorMan = new IndoorMan();
        //indoorMan.configureGas();
        indoorMan.preparecook();
    }


}
