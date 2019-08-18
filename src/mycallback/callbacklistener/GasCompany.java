package mycallback.callbacklistener;

public class GasCompany implements GasListener{

    @Override
    public void offerGas(String msg) {
        System.out.println("煤气公司的订单：" + msg);
    }

    public void advertiseTo(IndoorsMan man){

        System.out.println("我们是煤气公司，这是我们的联系方式，欢迎来电！");
        man.setListener(this);
    }

    public void advertiseTo(IndoorMan man){

        System.out.println("我们是煤气公司，这是我们的联系方式，欢迎来电！");
        man.setListener(this);
    }

    public void advertise(IndoorMan man) {

        System.out.println("我们是煤气公司，这是我们的联系方式，欢迎来电！");

    }
}
