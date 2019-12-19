package java8Feature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Java8List {

    public static void main(String[] args) {
        forEach1();
        forEach2();
    }

    public static void forEach1(){
        List<Student> list = new ArrayList();
        list.add(new Student("aaa","nan"));
        list.add(new Student("bbb","nan"));
        list.add(new Student("ccc","nv"));
        list.add(new Student("ddd","nv"));
        list.forEach((l)->{
            System.out.print(l.getSex() + "  ");
            System.out.println(l.getName());
        });
    }

    public static void forEach2(){
        Set<Student> set = new HashSet<>();
        set.forEach((s)->{
            System.out.print(s.getSex() + "  ");
            System.out.println(s.getName());
        });
    }


}
