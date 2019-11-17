package listsort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class ListSort {

    /*public static void main(String[] args) {

        new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        };
    }*/

    @Test
    public void testSortByName_with_plain_java() throws Exception {

        List<Human> list = new ArrayList();
        list.add(new Human("tom",22));
        list.add(new Human("dsaf",32));
        list.add(new Human("12eww",55));
        list.add(new Human("4twter",41));
        list.add(new Human("wter456",12));
        list.add(new Human("f6564gds",54));
        list.add(new Human("的算法",54));
        list.add(new Human("和金融业人体验",54));
        list.add(new Human("额外天热电",54));
        list.add(new Human("f名不虚传的",54));
        list.add(new Human("6分公司退热贴",54));
        list.add(new Human("啊啊法国队虽然",54));

        Collections.sort(list, new Comparator<Human>() {

            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });
        for (Human human:list){
            System.out.println("name  " + human.getName() + ",  age  " + human.getAge());
        }
        //Assert.assertThat(list.get(0), equalTo(new Human("dsaf", 32)));
    }


}
