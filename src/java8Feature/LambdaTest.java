package java8Feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {

        oldSort();
        newSort();
    }

    public static void newSort(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //传统方式
        Collections.sort(names,(String a,String b)->{
            return a.compareTo(b);
        });

        //还可以更简洁
        Collections.sort(names,(String a,String b)-> b.compareTo(a));

        //再简洁
        Collections.sort(names,(a,b)->a.compareTo(b));

        names.forEach(s -> {
            System.out.println(s);
        });
    }

    public static void oldSort(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        names.forEach(string->{
            System.out.println(string);
        });
    }
}
