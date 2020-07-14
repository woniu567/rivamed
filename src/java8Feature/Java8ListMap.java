package java8Feature;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8ListMap {

    public static void main(String[] args) {
        ArrayList<Student> students = listStudent();
        Set<String> names = students.stream().map(Student::getName).collect(Collectors.toSet());
        Map<String,String> studentMap = students.stream().collect(Collectors.toMap(student->student.getName(),student->student.getSex()));
        for (String str:names){
            System.out.println(str);
        }
        System.out.println("------------------------------------------");
        for (Map.Entry<String,String> entry:studentMap.entrySet()){
            System.out.println(entry.getKey() + "...." + entry.getValue());
        }
    }

    public static ArrayList<Student> listStudent(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("uoriwew","23"));
        students.add(new Student("sdfpsdw","34"));
        students.add(new Student("mweewio","45"));
        students.add(new Student("rewmnrw","56"));
        students.add(new Student("dewmfrl","67"));
        return students;
    }
}
