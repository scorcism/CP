ThreadWayTwo implements Runnable{
    public void run(){
        System.out.println("Thread runs...");
    }

    public static void main(String[] args){
        ThreadWayOne t1 = new ThreadWayOne();
        t1.start();
    }
}

