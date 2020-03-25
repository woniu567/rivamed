package listsort;

import java.util.ArrayList;
import java.util.List;

public class ListAdd {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("aa","aa","aa"));
        personList.add(new Person("bb","bb","bb"));
        personList.add(new Person("cc","cc","cc"));
        personList.add(new Person("dd","dd","dd"));
        personList.add(new Person("ee","ee","ee"));
        personList.add(new Person("ff","ff","ff"));
        personList.add(new Person("aa","aa","aa"));
        List<Person> persons = new ArrayList<>();

        outLoop:for (Person p:personList){
            if (!persons.contains(p)){
                persons.add(p);
            }else {
                continue outLoop;
            }
        }

        for (Person person:persons){
            System.out.println(person.getName() + ".." + person.getSex() + ".." + person.getAge());
        }

    }
}
