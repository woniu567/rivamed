package mylistener.listeningmechanism.listenerdemo1;

public class MyListener implements PersonListener{

    @Override
    public void dorun(Person person) {

        System.out.println("跑步跑步跑步");
    }

    @Override
    public void doeat(Person person) {
        System.out.println("吃饭吃饭吃饭");
    }
}
