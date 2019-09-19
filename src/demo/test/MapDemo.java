package demo.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        map1();
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

}
