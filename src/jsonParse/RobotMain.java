package jsonParse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotMain {

    public static void main(String[] args) {

        List<Man> manList = new ArrayList<>();
        manList.add(new Man("aaa","111"));
        manList.add(new Man("bbb","222"));
        manList.add(new Man("ccc","333"));
        manList.add(new Man("ddd","444"));
        manList.add(new Man("eee","555"));
        Man[] mans = new Man[5];

        manList.toArray(mans);

        Arrays.asList(mans).stream().forEach(x -> System.out.println(x.getName() + ": " + x.getAge()));
        Arrays.asList(mans).stream().forEach(man -> {
            System.out.println(man.getName() + ": " + man.getAge());
        });
    }
}
