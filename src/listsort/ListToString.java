package listsort;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class ListToString {

    public static void main(String[] args) {
        listToString1();
        System.out.println("---------------------------");
        listToString2();
    }

    //list"一键"转为String
    public static void listToString1(){
        List<String> list = new ArrayList();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        String join = String.join(",",list);
        System.out.println("join::::" + join);
    }

    public static void listToString2(){
        List<String> list = new ArrayList();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        String join = Joiner.on(",").join(list);
        System.out.println("join::::" + join);
    }
}
