package listsort;

import java.text.Collator;
import java.util.*;

public class ListSortEntity {

    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        list.add(new Human("刘媛媛",22));
        list.add(new Human("王硕",23));
        list.add(new Human("李明",24));
        list.add(new Human("刘迪",25));
        list.add(new Human("刘布",26));
        list.add(new Human("安达",27));
        list.add(new Human("陈晨",28));
        list.add(new Human("大刘",29));
        list.add(new Human("tom",21));
        list.add(new Human("dsaf",20));
        list.add(new Human("12eww",32));
        list.add(new Human("4twter",42));
        list.add(new Human("wter456",52));
        list.add(new Human("f6564gds",62));
        list.add(new Human("的算法",72));
        list.add(new Human("和金融业人体验",82));
        list.add(new Human("额外天热电",92));
        list.add(new Human("f名不虚传的",12));
        list.add(new Human("6分公司退热贴",45));
        list.add(new Human("啊啊法国队虽然",34));

        list.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                //实现对实体中包含汉字的排序
                Collator instance = Collator.getInstance(Locale.CHINA);
                return instance.compare(o1.getName(), o2.getName());
                //return o1.getName().compareTo(o2.getName());
            }
        });
        for (Human human:list){
            System.out.println(human.getName() + "  " +human.getAge());
        }
    }

}
