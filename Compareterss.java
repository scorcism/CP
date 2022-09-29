import java.util.*;

class Student {
    int roll;
    String name;

    Student(int roll,String name){
        this.roll = roll;
        this.name  = name;
    }

    public String toString(){
        return ("Name: " + name  + " roll: " + roll + "\n");
    }

}


public class Compareterss {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student(23, "Jash"));
        students.add(new Student(3, "Abhishek"));
        students.add(new Student(2, "Jash"));
        students.add(new Student(223, "Ram"));

        // System.out.println(students);
        students.forEach(System.out::println);
    }
}
