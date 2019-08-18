package my_tcp_udp.tcpjihedemo.jihedemo;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<Person>();
        List<Person> list2 = new ArrayList<Person>();

        Person p1 = new Person();
        p1.setName("aaaa");
        p1.setAge(11);
        Person p2 = new Person();
        p2.setName("bbbb");
        p2.setAge(22);
        Person p3 = new Person();
        p3.setName("cccc");
        p3.setAge(33);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        Map<String,List<Person>> map = new HashMap<>();
        map.put("person",list);

        Iterator<Map.Entry<String, List<Person>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<Person>> entry = it.next();
            String key = entry.getKey();
            List<Person> value = entry.getValue();
            for (Person person : value){
                System.out.println(person.getName());
            }
            //System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }


        /*Iterator<Map.Entry<String,List<TagInfo>>> it = epcMap.entrySet().iterator();
        //Iterator<epcMap.Entry<String, List<TagInfo>>> it = epcMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<TagInfo>> entry = it.next();
            String key = entry.getKey();
            List<TagInfo> value = entry.getValue();
            for (TagInfo person : value){
                System.out.println(person.getPc());
                String epc = person.getPc();
                if (this.messageListener != null)
                    messageListener.OnUhfScanRet(true, this.getIdentification(), "", epc);
                this.messageListener.OnUhfScanComplete(true, this.getIdentification());
            }
            //System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }*/

    }
}
