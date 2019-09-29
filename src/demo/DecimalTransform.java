package demo;

/*
    10进制转化其他进制	对应的方法,参数:n(原10进制数据),r(进制),返回值
    10进制转2进制	Integer.toBinaryString(n);	一个二进制字符串.
    10进制转8进制	Integer.toOctalString(n);	一个八进制字符串
    10进制转16进制	Integer.toHexString(n);	一个16进制字符串
    10进制转 r 进制	Integer.toString(100, 16);	一个r进制字符串
 */
public class DecimalTransform {

    public static void main(String[] args) {
        DecimalTrans();
        System.out.println("------------------------------");
        TransDecimal();
    }

    //十进制转其他进制
    public static void DecimalTrans(){
        int n = 18;
        System.out.println(n + " 的二进制是: " + Integer.toBinaryString(n));
        System.out.println(n + " 的八进制是: " + Integer.toOctalString(n));
        System.out.println(n + " 的十六进制是: " + Integer.toHexString(n));
        System.out.println(n + " 的三进制是: " + Integer.toString(n, 3));
    }

    //其他进制转十进制
    public static void TransDecimal(){
        String str1 = Integer.valueOf("776",8).toString();
        int str2 = Integer.valueOf("776",8);
        System.out.println(str1);
        System.out.println(str2);

        String it1 = Integer.valueOf("0101",2).toString();
        int it2 = Integer.valueOf("0101",2);
        System.out.println(it1);
        System.out.println(it2);

        String ii1 = Integer.valueOf("FFFF",16).toString();
        int ii2 = Integer.valueOf("FFFF",16);
        System.out.println(ii1);
        System.out.println(ii2);
    }

    public static void test(){
        int aa = 20;

    }
}
