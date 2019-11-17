package listsort;

import java.text.Collator;
import java.util.*;

public class ListSortHanzi {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("刘媛媛");
        list.add("王硕");
        list.add("李明");
        list.add("刘迪");
        list.add("刘布");
        list.add("安达");
        list.add("陈晨");
        list.add("大刘");
        list.add("tom");
        list.add("dsaf");
        list.add("12eww");
        list.add("4twter");
        list.add("wter456");
        list.add("f6564gds");
        list.add("的算法");
        list.add("和金融业人体验");
        list.add("额外天热电");
        list.add("f名不虚传的");
        list.add("6分公司退热贴");
        list.add("啊啊法国队虽然");

        //升序   注意：是根据的汉字的拼音的字母排序的，而不是根据汉字一般的排序方法
        Collections.sort(list, Collator.getInstance(Locale.CHINA));
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println();
        //降序
        Collections.reverse(list);
        for (String string : list) {
            System.out.println(string);
        }

        String[] names = {"王林",  "杨宝", "李镇", "刘迪", "刘波"};
        // 升序    按汉语拼音字母排序
        Arrays.sort(names, Collator.getInstance(Locale.SIMPLIFIED_CHINESE));
        System.out.println(Arrays.toString(names));
    }
}
