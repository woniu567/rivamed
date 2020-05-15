package FastJsonObject;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

/*
    JSONobject是FastJson提供的对象，在api中是用一个私有的常量map进行封装的，实际就是一个map，只不过FastJson对其进行了封装，
    添加了很多方便快捷的属性方法。
    private final Map<String, Object> map;
    需要加入阿里的fastjson的jar包
 */
public class JsonTest {

    /*
    常用方法，及作用：

    1.put(String key, Object value)方法，在JSONObject对象中设置键值对在，在进行设值得时候，key是唯一的，如果用相同的key不断设值得时候，保留后面的值。

    2.Object get(String key) :根据key值获取JSONObject对象中对应的value值，获取到的值是Object类型，需要手动转化为需要的数据类型

    3.int size():获取JSONObject对象中键值对的数量

    4.boolean isEmpty()：判断该JSONObject对象是否为空

    5.containsKey(Object key)：判断是否有需要的key值

    6.boolean containsValue(Object value)：判断是否有需要的value值

    7.JSONObject getJSONObject(String key)：如果JSONObjct对象中的value是一个JSONObject对象，即根据key获取对应的JSONObject对象；

    8.JSONArray getJSONArray(String key) ：如果JSONObject对象中的value是一个JSONObject数组，既根据key获取对应的JSONObject数组；

    9.Object remove(Object key)：根据key清除某一个键值对。

    由于JSONObject是一个map，它还具有map特有的两个方法：

    10.Set<String> keySet() ：获取JSONObject中的key，并将其放入Set集合中

    11.Set<Map.Entry<String, Object>> entrySet()：在循环遍历时使用，取得是键和值的映射关系，Entry就是Map接口中的内部接口

    与String字符串转换：

    12.toJSONString() /toString():将JSONObject对象转换为json的字符串
     */
    public static void main(String[] args) {

        JSONObject object1 = new JSONObject();
        object1.put("name","张三");
        object1.put("name1","张三1");
        object1.put("name2","张三2");
        object1.put("name3","张三3");
        object1.put("name4","张三4");

        //2.根据key获取value
        String name = (String) object1.get("name");
        System.out.println(name);

        //3.获取JSONObject中的键值对个数
        int size = object1.size();
        System.out.println(size);

        //4.判断是否为空
        boolean result = object1.isEmpty();
        System.out.println(result);

        //5.是否包含对应的key值，包含返回true，不包含返回false
        boolean isContainsKeyResult = object1.containsKey("name");
        System.out.println(isContainsKeyResult);

        //6.是否包含对应的value值，包含返回true，不包含返回false
        boolean isContainsValueResult = object1.containsValue("王五");
        System.out.println(isContainsValueResult);
        System.out.println("---------------------------------------------------");
        System.out.println();
        //7.JSONObjct对象中的value是一个JSONObject对象，即根据key获取对应的JSONObject对象；
        JSONObject object2 = new JSONObject();
        //将jsonobject对象作为value进行设置
        object2.put("student1", object1);
        JSONObject student =object2.getJSONObject("student1");
        System.out.println(student);
        System.out.println("---------------------------------------------------");
        System.out.println();
        //8.如果JSONObject对象中的value是一个JSONObject数组，既根据key获取对应的JSONObject数组；
        JSONObject objectArray = new JSONObject();
        //创建JSONArray数组
        JSONArray jsonArray = new JSONArray();
        //在JSONArray数组设值:jsonArray.add(int index, Object value);
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1, "another jsonArray value");
        objectArray.put("testArray", jsonArray);
        //获取JSONObject对象中的JSONArray数组
        JSONArray jsonArray2 = objectArray.getJSONArray("testArray");
        System.out.println(jsonArray2);
        System.out.println("---------------------------------------------------");
        System.out.println();
        //9.remove.根据key移除JSONObject对象中的某个键值对
        object1.remove("name");
        System.out.println(object1);
        System.out.println("---------------------------------------------------");
        System.out.println();
        //10.取得JSONObject对象中key的集合
        Set<String> keySet= object1.keySet();
        for (String key : keySet) {
            System.out.print("   "+key);
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();
        //11.取得JSONObject对象中的键和值的映射关系
        Set<Map.Entry<String, Object>> entrySet = object1.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            System.out.println(entry);
        }
        System.out.println("---------------------------------------------------");
        System.out.println();
        //12.转换为json字符串
        String str1 = object1.toJSONString();
        System.out.println(str1);
        String str2 =object1.toString();
        System.out.println(str2);
    }
}
