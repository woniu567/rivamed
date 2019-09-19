package demo.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        //map1();
        map2();
    }

    // 遍历方法一 hashmap entrySet() 遍历
    public static void map1(){
        Map<String,Integer> tempMap = new HashMap();
        tempMap.put("aa",5465);
        tempMap.put("bb",5645);
        tempMap.put("cc",7894);
        tempMap.put("dd",1321);
        tempMap.put("ee",3761);
        Iterator it = tempMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key::" + key + " value::" + value);
        }

    }

    // 遍历方法二 hashmap entrySet() 遍历
    public static void map2(){
        Map<String,Integer> tempMap = new HashMap();
        tempMap.put("aa",5465);
        tempMap.put("bb",5645);
        tempMap.put("cc",7894);
        tempMap.put("dd",1321);
        tempMap.put("ee",3761);
        for (Map.Entry<String,Integer> entry:tempMap.entrySet()){
            System.out.println("key..." + entry.getKey() + "          value..." + entry.getValue());
        }

    }

}
