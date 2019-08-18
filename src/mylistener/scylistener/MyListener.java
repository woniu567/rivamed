package mylistener.scylistener;

public class MyListener implements Listener{

    @Override
    public void eventChanged(MyEvent e) {

        // TODO Auto-generated method stub
        System.out.println("value changed to:" + e.getValue());
    }
}
