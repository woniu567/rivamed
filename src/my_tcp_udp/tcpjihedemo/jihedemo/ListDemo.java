package my_tcp_udp.tcpjihedemo.jihedemo;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("eiuowie");
        list.add("jkdsfwe");
        list.add("eiuowie");
        list.add("uieijfd");
        list.add("cnvkslj");
        list.add("paddfdo");
        list.add("klekexo");
        list.add("nenewew");
        list.add("vopidop");
        list.add("vopidop");

        System.out.println();
        System.out.println("-------------------- set集合去重，不改变原有方式 --------------------");
        listDemo1(list);
        System.out.println();
        System.out.println("-------------------- 遍历后赋给另一个list --------------------");
        listDemo2(list);
        System.out.println();
        System.out.println("-------------------- set去重 --------------------");
        listDemo3(list);
        System.out.println();
        System.out.println("-------------------- 去重并按自然顺序排序 --------------------");
        listDemo4(list);
        System.out.println();
        System.out.println("-------------------- 对象去重 --------------------");

        Data data1 = new Data(1,"aaaa");
        Data data2 = new Data(2,"dddd");
        Data data3 = new Data(1,"vvvv");
        Data data4 = new Data(4,"rrrr");
        Data data5 = new Data(1,"ssss");
        Data data6 = new Data(5,"rrrr");

        List<Data> list1 = new ArrayList<>();
        list1.add(data1);
        list1.add(data2);
        list1.add(data3);
        list1.add(data4);
        list1.add(data5);
        list1.add(data6);
        List<Data> ll = Arrays.asList(data1,data2,data3,data4,data5,data6);
        //List<Data> l = test(ll);
        //System.out.println(Arrays.toString(l.toArray()));

    }

    //1、set集合去重，不改变原有方式
    public static void listDemo1(List<String> list){
        System.out.println("list = " + list.toString());
        List<String> listNew = new ArrayList<>();
        Set set = new HashSet<>();
        for(String str : list) {
            if(set.add(str)){
                listNew.add(str);
            }
        }
        System.out.println("listNew = " + listNew.toString());
    }

    //2、遍历后赋给另一个list
    public static void listDemo2(List<String> list){
        System.out.println("list = " + list.toString());
        List<String> listNew = new ArrayList<>();
        for(String str : list){
            if(!listNew.contains(str)){
                listNew.add(str);
            }
        }
        System.out.println("listNew = " + listNew.toString());
    }

    //3、set去重
    public static void listDemo3(List<String> list){
        System.out.println("list = " + list);
        Set<String> set = new HashSet<>();
        set.addAll(list);
        List<String> listNew = new ArrayList<>();
        listNew.addAll(set);
        System.out.println("listNew = " + listNew);
    }

    //4、去重并按自然顺序排序
    public static void listDemo4(List<String> list){
        System.out.println("list = " + list);
        TreeSet<String> ts = new TreeSet<>();
        ts.addAll(list);
        List<String> listNew = new ArrayList<>();
        listNew.addAll(ts);
        System.out.println("listNew = " + listNew);
    }

    //5、对象去重
    /*public static List<Data> test(List<Data> list){
        List<Data> unique = list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Data::getId))), ArrayList::new)
        );
        return unique;
    }*/

}


class Data{

    private int id;
    private String name;

    public Data(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data:" + " id=" + id + " name=" + name;
    }
}
