import java.util.*;

class Boys {
    int age;
    String name;

    Boys(int a, String n) {
        this.age = a;
        this.name = n;
    }
}

public class ComparetersComparatable {
    public static void main(String[] args) {

        // Using lamba
        List<Boys> list = new ArrayList<>();
        list.add(new Boys(20, "Jash"));
        list.add(new Boys(2, "Ramu"));
        list.add(new Boys(3, "Shym"));
        list.add(new Boys(43, "Rohan"));
        list.add(new Boys(23, "mm"));
        list.add(new Boys(220, "Abhishek"));

        // Ascending order a - b
        System.out.println("Ascending Order");
        Collections.sort(list,(a,b)->a.age - b.age);
        for(Boys b: list){
            System.out.println("name:" + b.name +" age: "+ b.age);
        }
        System.out.println();
        System.out.println("Decending Order");
        Collections.sort(list,(c,d)->d.age - c.age);
        for(Boys c: list){
            System.out.println("name:" + c.name +" age: "+ c.age);
        }




        List<Student> students = new ArrayList<>();

        students.add(new Student(23, "Jash"));
        students.add(new Student(3, "Abhishek"));
        students.add(new Student(2, "Jash"));
        students.add(new Student(223, "Ram"));

        // Collections.sort(students);
        /*
         * Collections.sort(students,(o1,o2)->{
         * if(o1.name.equals(o2.name)){
         * return o1.roll - o2.roll;
         * } else {
         * return o1.name.compareTo(o2.name);
         * }
         * });
         */

        // Collections.sort(students, Comparator.comparing(Student::getName)
        //         .thenComparing(Student::getRoll).reversed());

        // students.forEach(System.out::println);
    }

}

class Student implements Comparable<Student> {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", roll=" + roll + "]";
    }

    @Override
    public int compareTo(Student obj) {
        /*
         * eg.
         * public int compareTo(Student a, Student b) {
         * // sort student age by ascending
         * a.age- b.age;
         * 
         * // sort age by deceding
         * b.age-a.age;
         * 
         * }
         * 
         */
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

// @Override
// public int compare(Student o1, Student o2){
// if(o1.name.equals(o2.name)){
// return o1.roll - o2.roll;
// }
// }
// }
