
class MyThread1 extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i < 40000) {
            System.out.println("1");
            i++;
        }
    }
}

class MyThread2 extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i < 40000) {
            System.out.println("2");
            i++;
            Thread.sleep(200);
        }
    }
}

public class Thread_s {

    public static void main(String[] args) {

        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.start();
        // t1.sleep(4);
        t2.start();

    }
}
