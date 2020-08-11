package listsort;

import java.util.ArrayList;
import java.util.List;

public class ListChange {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("aaaa","bbbb","5555"));
        list.get(0).setAge("6666");
        System.out.println(list.get(0).getAge());
    }
}
