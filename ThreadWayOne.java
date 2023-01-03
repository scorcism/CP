

// Extending the Thread class

Extending the Thread classThreadWayOne extends Thread{

    public void run(){
        System.out.println("Thread runs...");
    }

    public static void main(String[] args){
        ThreadWayOne t1 = new ThreadWayOne();
        t1.start();
    }
}