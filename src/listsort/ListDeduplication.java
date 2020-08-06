package listsort;

import java.util.ArrayList;

//很好的去重
public class ListDeduplication {

    public static void main(String[] args) {
        ArrayList<String> list = stringList();
        ArrayList<String> strList = new ArrayList<>();
        strList.add("nmbxds");
        strList.add("eikdds");
        strList.add("jldsds");
        for (String str:list){
            if (!strList.contains(str)){
                strList.add(str);
            }
        }
        for (String s:strList){
            System.out.println(s);
        }
    }

    public static ArrayList<String> stringList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("yeiw");
        list.add("jlds");
        list.add("nmbx");
        list.add("eikd");
        list.add("cmdk");
        return list;
    }
}
