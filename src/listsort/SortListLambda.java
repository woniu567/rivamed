package listsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class SortListLambda {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(10, "red"));
        inventory.add(new Apple(5, "red"));
        inventory.add(new Apple(1, "green"));
        inventory.add(new Apple(15, "green"));
        inventory.add(new Apple(2, "red"));

        //方法一
        inventory.sort(new AppleComparator());
        /*for (Apple apple:inventory){
            System.out.println("weight" + apple.getWeight() + ", color" + apple.getColor());
        }*/

        // 2、匿名内部类
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        /*for (Apple apple:inventory){
            System.out.println("weight" + apple.getWeight() + ", color" + apple.getColor());
        }*/

        // 3、使用Lambda表达式
        inventory.sort((a, b) -> a.getWeight() - b.getWeight());
        for (Apple apple:inventory){
            System.out.println("weight" + apple.getWeight() + ", color" + apple.getColor());
        }

        // 4、使用Comparator的comparing
        Comparator<Apple> comparing = comparing((Apple a) -> a.getWeight());
        inventory.sort(comparing((Apple a) -> a.getWeight()));
        //或者等价于
        //inventory.sort(comparing(Apple::getWeight));
        for (Apple apple:inventory){
            System.out.println("weight" + apple.getWeight() + ", color" + apple.getColor());
        }

        /**
         * 逆序排序
         */
        // 1、 根据重量逆序排序
        inventory.sort(comparing(Apple::getWeight).reversed());
        for (Apple apple:inventory){
            System.out.println("weight" + apple.getWeight() + ", color" + apple.getColor());
        }

        // 2、如果两个苹果的重量一样重，怎么办？那就再找一个条件进行排序呗
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        for (Apple apple:inventory){
            System.out.println("weight" + apple.getWeight() + ", color" + apple.getColor());
        }
    }
}
