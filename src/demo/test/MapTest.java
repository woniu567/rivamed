package demo.test;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        //map1();
        //map2();
        map3();
        System.out.println("------------------------------");
        map4();
        System.out.println("------------------------------");
        map5();
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

    // 遍历方法三 hashmap keySet() 遍历
    public static void map3(){
        Map<String,Integer> tempMap = new HashMap();
        tempMap.put("aa",5465);
        tempMap.put("bb",5645);
        tempMap.put("cc",7894);
        tempMap.put("dd",1321);
        tempMap.put("ee",3761);
        for (Iterator iterator = tempMap.keySet().iterator();iterator.hasNext();){
            Object key = iterator.next();
            System.out.println("key.." + key + "  value.." + tempMap.get(key));
        }
    }

    //遍历方法四 tempMap keySet()遍历
    public static void map4(){
        Map<String,Integer> tempMap = new HashMap();
        tempMap.put("aa",5465);
        tempMap.put("bb",5645);
        tempMap.put("cc",7894);
        tempMap.put("dd",1321);
        tempMap.put("ee",3761);
        for (Object o:tempMap.keySet()){
            System.out.println("key.." + o + "  value.." + tempMap.get(o));
        }
    }

    //java如何遍历Map <String, ArrayList> map = new HashMap <String,ArrayList>();
    public static void map5(){
        List<String> list1 = new ArrayList<>();
        list1.add("dfewer");
        list1.add("rdeter");
        list1.add("edjrer");
        List<String> list2 = new ArrayList<>();
        list2.add("dfsewr");
        list2.add("jkiyuy");
        list2.add("puimmg");
        List<String> list3 = new ArrayList<>();
        list3.add("qwedsa");
        list3.add("mbdfer");
        list3.add("zxcber");
        List<String> list4 = new ArrayList<>();
        list4.add("truyry");
        list4.add("wqewsa");
        list4.add("pukmfs");

        Map<String,ArrayList> map = new HashMap<>();
        map.put("aaa", (ArrayList) list1);
        map.put("bbb", (ArrayList) list2);
        map.put("ccc", (ArrayList) list3);
        map.put("ddd", (ArrayList) list4);
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            ArrayList arrayList = map.get(key);
            for (Object o:arrayList){
                System.out.println(key + "----" + o);
            }
        }
        Map<String,List> map1 = new HashMap<>();
        map1.put("eee",list1);
        map1.put("fff",list2);
        map1.put("ggg",list3);
        map1.put("hhh",list4);
        for (Map.Entry<String,List> entry:map1.entrySet()){
            String key = entry.getKey().toString();
            List<String> list = entry.getValue();
            for (String value:list){
                System.out.println(key + "-----------" + value);
            }
        }
    }
}
