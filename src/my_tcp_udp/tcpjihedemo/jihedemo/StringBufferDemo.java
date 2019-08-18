package my_tcp_udp.tcpjihedemo.jihedemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringBufferDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("dsfds");
        set.add("fgdfg");
        set.add("kktrw");
        set.add("pisdf");
        set.add("dfgfk");
        StringBuffer sb = new StringBuffer();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String str = it.next();
            sb.append(str+" ");
        }
        System.out.println(sb.toString());

        StringBuilder sbb = new StringBuilder();
        for (String strr : set) {
            if (strr instanceof String)
            sbb.append(strr+" ");
        }
        System.out.println(sbb.toString());




    }
}
