package threadpool.threaddemo1;

public class TestMain {

    public static void main(String[] args) {
        User user = new User();
        new Thread(new Input(user)).start();
        new Thread(new Output(user)).start();
    }
}
