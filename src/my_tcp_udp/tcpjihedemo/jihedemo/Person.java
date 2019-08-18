package my_tcp_udp.tcpjihedemo.jihedemo;

public class Person {

    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
