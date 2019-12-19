package java8Feature;

import java.util.HashMap;
import java.util.Map;

public class Java8Map {

    public static void main(String[] args) {
        mapEach1();
    }

    public static void mapEach1(){
        Map<String,String> map= new HashMap<>();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");

        map.forEach((k,v)->{
            // 打印键
            System.out.print(k + "    ");
            // 打印值
            System.out.println(v);
        });
    }
}
