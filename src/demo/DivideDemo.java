package demo;

import java.text.DecimalFormat;

public class DivideDemo {

    public static void main(String[] args) {
        int a = 3501;
        int b = 1000;
        DecimalFormat df=new DecimalFormat("0.000");//设置保留位数
        String c = df.format((float)a/b);
        System.out.println(c);
    }
}
