class MyThreadRunnable1 implements Runnable {
    public void run() {
        for (int i = 0; i < 40000; i++) {
            System.out.println("T1");
        }
    }
}

class MyThreadRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 40000; i++) {

            System.out.println("T2");
        }
    }
}

class ThreadWayTwo {

    public static void main(String[] args) {
        MyThreadRunnable1 t1 = new MyThreadRunnable1();
        Thread th1 = new Thread(t1);
        MyThreadRunnable2 t2 = new MyThreadRunnable2();
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();
    }
}
