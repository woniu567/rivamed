package demo;

import java.util.ArrayList;
import java.util.List;

//list集合，把特定元素放到首位
public class listFirst {

    public static void main(String[] args) {

        sortFirst();
    }

    public static void sortFirst(){

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        List<String> ss = new ArrayList<>();
        for (String s:list){
            if (s.equals("cc")){
                ss.add(0,s);
            }else {
                ss.add(s);
            }
        }

        for (String str:ss){
            System.out.println(str);
        }
    }

}
