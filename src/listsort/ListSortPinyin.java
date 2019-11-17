package listsort;

import mycallback.callback.demo2.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortPinyin {

    public static void main(String[] args) {
        List<Human> list = new ArrayList();
        list.add(new Human("tom",22));
        list.add(new Human("dsaf",32));
        list.add(new Human("12eww",55));
        list.add(new Human("4twter",41));
        list.add(new Human("wter456",12));
        list.add(new Human("f6564gds",54));

        /*Collections.sort(list);//默认排序(从小到大)
         for(int i : list){
                 System.out.println(i);
             }

         Collections.reverse(list);//倒叙(从大到小)
         for(int i : list){
                 System.out.println(i);
         }*/

        //list.sort(Comparator.naturalOrder());//正序比较
        /*Collections.sort(list);//正序比较

        for(Human i : list){
            System.out.println(i.getName() + "  " + i.getAge());
        }*/

        list.sort(Comparator.naturalOrder());//正序比较
        //Collections.sort(list);//正序比较

        for(Human i : list){
            System.out.println(i.getName() + "   " +i.getAge());
        }
    }
}
