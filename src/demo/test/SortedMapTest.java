package demo.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * SortedMap的主要特征是，它按照自然顺序或指定的比较器对键进行排序。因此，如果您想要满足以下条件的map，请考虑使用TreeMap：
 *
 *  不允许使用null键或null值。
 *  密钥按自然排序或指定的比较器排序。
 *
 * SortedMap的方法：
 *
 *  subMap（K fromKey，K toKey）：返回此Map部分的视图，其键的范围从fromKey（包含）到toKey（不包括）。
 *  headMap（K toKey）：返回此Map部分的视图，其键严格小于toKey。
 *  tailMap（K fromKey）：返回此Map部分的视图，其键大于或等于fromKey。
 *  firstKey（）：返回此Map中当前的第一个（最低）键。
 *  lastKey（）：返回此Map中当前的最后一个（最高）键。
 *  comparator（）：返回用于对此Map中的键进行排序的Comparator，如果此Map使用其键的自然顺序，则返回null。
 */
public class SortedMapTest {

    public static void main(String[] args) {

        sortMap();
        System.out.println("===============================================================================");
        sortMap2();
        System.out.println("===============================================================================");
        sortMap3();
    }

    public static void sortMap(){
        SortedMap<Integer, String> sm = new TreeMap<Integer, String>();
        sm.put(new Integer(2), "practice");
        sm.put(new Integer(3), "quiz");
        sm.put(new Integer(5), "code");
        sm.put(new Integer(4), "contribute");
        sm.put(new Integer(1), "geeksforgeeks");
        Set s = sm.entrySet();

        // Using iterator in SortedMap
        Iterator i = s.iterator();

        // Traversing map. Note that the traversalproduced sorted (by keys) output .
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();
            int key = (Integer)m.getKey();
            String value = (String)m.getValue();
            System.out.println("Key : " + key + "  value : " + value);
        }
    }

    public static void sortMap2(){
        //HashMap<String,String> map=new HashMap<String, String>();
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("4","44");
        map.put("3", "33");
        map.put("1","11");
        map.put("2", "22");
        map.put("z", "10");
        map.put("b", "5");
        map.put("a", "6");
        map.put("c", "20");
        map.put("d", "1");
        map.put("e", "7");
        map.put("y", "8");
        map.put("n", "99");
        map.put("j", "50");
        map.put("m", "2");
        map.put("f", "9");
        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println("排序之前:"+entry.getKey()+" 值"+entry.getValue());
        }
        System.out.println("===============================================================================");
        SortedMap<String,String> sort=new TreeMap<String,String>(map);
        Set<Map.Entry<String,String>> entry1=sort.entrySet();
        Iterator<Map.Entry<String,String>> it=entry1.iterator();
        while(it.hasNext()) {
            Map.Entry<String,String> entry=it.next();
            System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());
        }
    }

    public static void sortMap3(){
        SortedMap<String,String> map = null ;
        map = new TreeMap<String,String>() ;   //通过子类实例化接口对象
        map.put("D","DDDDD") ;
        map.put("A","AAAAA") ;
        map.put("C","CCCCC") ;
        map.put("B","BBBBB") ;

        System.out.println("第一个元素的key:" + map.firstKey()) ;
        System.out.println("key对于的值为:" + map.get(map.firstKey())) ;

        System.out.println("最后一个元素的key:" + map.lastKey()) ;
        System.out.println("key对于的值为:" + map.get(map.lastKey())) ;

        System.out.println("返回小于指定范围的集合（键值小于“C”）") ;
        for(Map.Entry<String,String> me:map.headMap("C").entrySet()){
            System.out.println("\t|- " + me.getKey() + "-->" + me.getValue()) ;
        }
        System.out.println("返回大于指定范围的集合（键值大于等于“C”）") ;
        for(Map.Entry<String,String> me:map.tailMap("C").entrySet()){
            System.out.println("\t|- " + me.getKey() + "-->" + me.getValue()) ;
        }
        System.out.println("返回部分集合（键值“B”和“D”之间,包括B不包括D）") ;
        for(Map.Entry<String,String> me:map.subMap("B","D").entrySet()){
            System.out.println("\t|- " + me.getKey() + "-->" + me.getValue()) ;
        }
    }
}
