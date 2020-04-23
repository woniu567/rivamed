package listsort;

import java.util.*;

/**
 * ArrayList 底层实现就是数组，且ArrayList实现了RandomAccess，表示它能快速随机访问存储的元素，通过下标 index 访问，
 * 只是我们需要用 get() 方法的形式， 数组支持随机访问， 查询速度快， 增删元素慢；
 *
 * LinkedList 底层实现是链表， LinkedList 没有实现 RandomAccess 接口，链表支持顺序访问， 查询速度慢， 增删元素快
 */
public class ListDemo {

    public static void main(String[] args) {

        //随着数据量的加大list的遍历，比linkList的遍历会快很多
        ArrayList<Integer> aList = (ArrayList<Integer>) initList(new ArrayList<>(), 300000);
        LinkedList<Integer> lList = (LinkedList<Integer>) initList(new LinkedList<>(), 300000);

        accessList(aList);
        accessList(lList);

        System.out.println("ArrayList----------");
        accessListByLoop(aList);
        accessListByIterator(aList);

        System.out.println("LinkedList----------");
        accessListByLoop(lList);
        accessListByIterator(lList);
    }

    /**
     * 遍历 list，判断是否实现 RandomAccess 接口来使用不同的遍历方法
     * @param list
     */
    public static void accessList(List list) {
        long startTime = System.currentTimeMillis();

        if (list instanceof RandomAccess) {
            System.out.println("实现了 RandomAccess 接口...");
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
        } else {
            System.out.println("没实现 RandomAccess 接口...");
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                iterator.next();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("遍历时间：" + (endTime - startTime));
    }

    /**
     * loop 遍历 list
     */
    public static void accessListByLoop(List list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("loop遍历时间：" + (endTime - startTime));
    }

    /**
     * 迭代器遍历
     */
    public static void accessListByIterator(List list) {
        long startTime = System.currentTimeMillis();

        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            iterator.next();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Iterator遍历时间：" + (endTime - startTime));
    }


    /**
     * 初始化 list，添加n个元素
     * @param list
     * @return
     */
    public static <T> List initList(List list, int n) {
        for (int i = 0; i < n; i++)
            list.add(i);
        return list;
    }
}
