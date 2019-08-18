package my_tcp_udp.tcpjihedemo.jihedemo;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {
        String[] str = {"abc", "bcd", "def"};
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length; i++){
            sb. append(str[i]);
        }
        String s = sb.toString();
        System.out.println(s);

        //如果是 “字符数组” 转 “字符串” 可以通过下边的方法
        char[]  data={'a','b','c'};
        String  string = new   String(data);
        System.out.println(string);

        Set myset = new HashSet();
        String s1 = "aa";
        String s2 = "bb";
        String s3 = "cc";
        String s4 = "dd";
        String s5 = "aa";
        myset.add(s1);
        myset.add(s2);
        myset.add(s3);
        myset.add(s4);
        myset.add(s5);
        System.out.println(myset);
        List list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        System.out.println(list);
        //List list = new ArrayList(myset);
        //System.out.println(list);

        List linklist = new LinkedList();
        linklist.add(null);
        linklist.add("");
        linklist.add(" ");
        linklist.add(s1);
        System.out.println(linklist);
    }
}
