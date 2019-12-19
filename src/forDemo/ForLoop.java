package forDemo;

import java.util.ArrayList;
import java.util.List;

public class ForLoop {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("aaaa","nan"));
        list.add(new Person("bbbb","nv"));
        list.add(new Person("cccc","nan"));
        list.add(new Person("dddd","nv"));

        boolean isTrue = false;
        for (Person person:list){
            if (person.getName().equals("bbbb")){
                person.setSex("nan");
                isTrue = true;
                break;
            }else {
                isTrue = false;
            }
        }
        if (!isTrue){
            Person person = new Person("eeee","nan");
            list.add(person);
        }

        for (Person person:list){
            System.out.println("name:" + person.getName() + "  sex:" + person.getSex());
        }
    }
}
