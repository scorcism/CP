

class ExceptionHandling{

    public static void main(String[] args){

    }

    // Explicitly we have to mention
    static int divide(int a, int b) throws ArithematicException{
        if(b==0){
            throw new ArithematicException("Do not divind by 0");
        }
        return a/b;
    }

}