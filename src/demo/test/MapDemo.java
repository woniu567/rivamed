package demo.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        //map1();
        //map2();
        map3();
    }

    public static void map1(){
        Map<String,String> map = new HashMap<>();
        map.put("adadf","132456");
        map.put("jyrty","345746");
        map.put("oqwpa","123750");
        map.put("56tsd","fse456");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key:: " + key + "   value:: " + value);
        }
    }

    public static void map2(){
        Map<String,Integer> tempMap = new HashMap();
        tempMap.put("aa",5465);
        tempMap.put("bb",5645);
        tempMap.put("cc",7894);
        tempMap.put("dd",1321);
        tempMap.put("ee",3761);
        for (Map.Entry<String,Integer> entry:tempMap.entrySet()){
            System.out.println("key.." + entry.getKey() + "  value.." + entry.getValue());
        }
    }

    public static void map3(){
        Map<String,Integer> testMap = new HashMap();
        testMap.put("aa",5465);
        testMap.put("bb",5479);
        testMap.put("cc",5979);
        testMap.put("aa",3489);
        for (Map.Entry<String,Integer> entry:testMap.entrySet()){
            System.out.println("key.." + entry.getKey() + "  value.." + entry.getValue());
        }
    }

}
