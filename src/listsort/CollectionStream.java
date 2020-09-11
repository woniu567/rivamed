package listsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionStream {

    public static void main(String[] args) {

        //sortList();
        filterTset();
    }


    //根据集合中对象Person中的伴随度进行倒序排列...reversed(),默认正序,reversed反转后即倒序;
    public static void sortList(){

        List<Person> listResult = new ArrayList<>();
        listResult.add(new Person("aklwen","asex","11"));
        listResult.add(new Person("biwoem","bsex","22"));
        listResult.add(new Person("cspoie","csex","33"));
        listResult.add(new Person("dvnhjw","dsex","44"));

                //对listResult进行排序,根据伴随度进行降序
        List<Person> collect = listResult.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList());

        collect.forEach(person -> {
            System.out.println(person.getName() + ".." + person.getSex() + ".." + person.getAge());
        });
    }

    //过滤,过滤掉collisionEntity中年龄大于5次的结果,firstA中存放的都是多于两次的
    public static void filterTset(){

        List<Human> listEntity = new ArrayList<>();
        listEntity.add(new Human("edsklr",32));
        listEntity.add(new Human("tuiedj",35));
        listEntity.add(new Human("klsaep",23));
        listEntity.add(new Human("znxmdk",29));
        listEntity.add(new Human("woseki",34));
        listEntity.add(new Human("slkdkf",37));
        listEntity.add(new Human("pajdow",25));
        listEntity.add(new Human("mnxnaj",26));
        listEntity.add(new Human("kjslde",28));
        List<Human> firstA = listEntity.stream()
                .filter(collisionEntity -> collisionEntity.getAge() >= 29)
                .collect(Collectors.toList());

        firstA.forEach(human -> {
            System.out.println(human.getName() + ".." + human.getAge());
        });

        //根据匹配次数正序排列,从小到大
        List<Human> result = firstA.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .collect(Collectors.toList());//根据matchnums排序
    }
}
