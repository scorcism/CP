

// To compare this objects we have to implement comparable 
class Student implements Comparable<Student>{
    int roll;
    int marks;

    Student(int a, int b){
        this.roll = a;
        this.marks = b;
    }

    public int compareTo(Student o){
        int diff = this.roll - o.roll;
        // if diff = 0 both are equal
        // if diff is less then 1 o is bigger
        // else o is smaller

    }
}


class ComparingObjects{

    public static void main(String[] args){
        Student abhishek = new Student(48,86);
        Student simran = new Student(38,94);


    }
}