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
        //DecimalTrans();
        System.out.println("------------------------------");
        //TransDecimal();
        System.out.println("------------------------------");
        test();
        System.out.println("------------------------------");
        chang16();
        System.out.println("------------------------------");
        demoTest();
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
        String string = "0A020304000B";
        Long decimal = Long.valueOf(string,16);
        System.out.println(decimal.toString());
        String str = string.substring(8,12);
        System.out.println(str);
        String aa = Integer.valueOf(str,16).toString();
        System.out.println(aa);
    }

    public static void chang16() {
        String str="aabbcc";
        String myStr[]={"a","b","c","d","e","f"};
        //String myStr[] = str.split("");
        int result=0;
        int n=1;
        for(int i=str.length()-1;i>=0;i--){
            String param=str.substring(i,i+1);
            for(int j=0;j<myStr.length;j++){
                if(param.equalsIgnoreCase(myStr[j])){
                    param="1"+String.valueOf(j);
                }
            }
            result+=Integer.parseInt(param)*n;
            n*=16;
        }
        System.out.println(result);
        System.out.println(Integer.parseInt(str, 16));
    }

    public static void demoTest(){
        int n = 1;
        for (int i=1;i<4;i++){
            n *= 16;
            System.out.println(n);
        }
    }
}
