import java.util.*;

class Student  implements Comparable<Student>  {
    int roll;
    String name;

    Student(int roll,String name){
        this.roll = roll;
        this.name  = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", roll=" + roll + "]";
    }

    @Override
    public int compareTo(Student obj) {
        // return this.roll - obj.roll; // Print in ascending
        return obj.roll - this.roll; // Print in decending

    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }
}

// class compareByName implements Comparator<Student>{
    
//     @Override
//     public int compare(Student o1, Student o2){
//         if(o1.name.equals(o2.name)){
//             return o1.roll - o2.roll;
//         }
//     }
// }

public class ComparetersComparatable{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student(23, "Jash"));
        students.add(new Student(3, "Abhishek"));
        students.add(new Student(2, "Jash"));
        students.add(new Student(223, "Ram"));

        // Collections.sort(students);
        /* 
        Collections.sort(students,(o1,o2)->{
            if(o1.name.equals(o2.name)){
                return o1.roll - o2.roll;
            } else {
                return o1.name.compareTo(o2.name);
            }
        });
        */

        Collections.sort(students,Comparator.comparing(Student::getName)
        .thenComparing(Student::getRoll).reversed());

        students.forEach(System.out::println);
    }


   
}
