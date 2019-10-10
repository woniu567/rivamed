package demo.test;

import java.util.ArrayList;
import java.util.List;

public class ListIterable {

    public static void main(String[] args) {

        List<Peple> list = new ArrayList<>();
        list.add(new Peple("aa",33));
        list.add(new Peple("bb",22));
        list.add(new Peple("cc",11));

        Iterable<Peple> iterables = list;
        for (Peple peple:iterables){
            System.out.println(peple.getName());
            System.out.println(peple.getAge());
        }
    }
}
