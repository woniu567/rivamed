package mylistener.listeningmechanism.listenerdemo1;

public class Main {


    public static void main(String[] args) {

        PersonSource personSource = new PersonSource();
        personSource.registerListener(new MyListener());
        personSource.run();
        personSource.eat();
    }
}
