package java8Feature;

public class InterfaceTest {

    public static void main(String[] args) {
        //Formula接口在拥有calculate方法之外同时还定义了sqrt方法，实现了Formula接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        Double c = formula.calculate(100);     // 100.0
        Double d = formula.sqrt(16);           // 4.0

        System.out.println(c);
        System.out.println(d);
    }
}
