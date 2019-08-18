package mylistener.scylistener;

/*
注册监听器
    在其他代码中把MyListener注册到MySource:
 */

public class Main {

    /**
     * @param args
     */

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        MySource s = new MySource();
        MyListener l = new MyListener();
        s.addListener(l);
        s.setValue(10);

    }
}


