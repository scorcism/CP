
class MyThr1 extends Thread {

    public MyThr1(String name) {
        super(name);
    }

    public void run() {
        int i = 0;
        while (i < 4) {
            System.out.println("T11111111111");
            i++;
        }
    }
}

class MyThr2 extends Thread {

    public MyThr2(String name) {
        super(name);
    }

    public void run() {
        int i = 0;
        while (i < 4000) {
            System.out.println("T2222222222");
            i++;
        }
    }
}

// Extending the Thread class
class ThreadWayOne {
    public static void main(String[] args) {
        MyThr1 t1 = new MyThr1("Thread 1");
        // MyThr2 t2 = new MyThr2("Thread 2");
        t1.start();
        // t2.start();

        // get ID of a thread
        System.out.println("Thread ID: "+ t1.getId());
        System.out.println("thread Name: "+t1.getName());
        System.out.println("Thread Priority: " + t1.getPriority());
    }
}