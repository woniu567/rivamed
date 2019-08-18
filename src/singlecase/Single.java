package singlecase;

import sun.management.jmxremote.SingleEntryRegistry;

public class Single {

    private Single(){}
    private static Single ss = new Single();
    public static Single getInstance(){
        return ss;
    }


    /*private Single(){}
    private static Single ss = null;
    public static Single getInstance(){
        if (ss == null){
            ss = new Single();
        }
        return ss;

    }*/
}
