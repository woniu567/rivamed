package my_tcp_udp.tcpjihedemo.duixiangquchong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        List<Person> list=new ArrayList<Person>();

        Person p1 = new Person("1", "boonya", 20);
        Person p2 = new Person("2", "boonya", 20);
        Person p3 = new Person("3", "boonya", 20);
        Person p4 = new Person("4", "fdsfew", 31);
        Person p5 = new Person("4", "irtyts", 41);
        Person p6 = new Person("6", "mfsqet", 28);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        Map<String,Object> map=new HashMap<String, Object>();
        for (Person person : list) {
            if(!map.containsKey(""+person.toString().hashCode())){
                map.put(person.toString().hashCode()+"", person);
            }
        }

        for (Object  person : map.values()) {
            Person uniquePerson=(Person) person;
            System.out.println(uniquePerson.getId()+" "+uniquePerson);
        }

    }
}
