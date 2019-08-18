package demo.test;

public class TestDemo {

    public static void main(String[] args) {
        int a = 56;
        System.out.println(56/10);
        System.out.println(56%10);

        String string = String.format("DEVICE_%s_%s_%s","abcd","efgh","ijklmn");
        String str = String.format("DEVICE.%s.%s.%s","abcd","efgh","ijklmn");
        System.out.println(string);
        System.out.println(str);
    }
}
