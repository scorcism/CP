import java.util.Stack;

public class StackDS {
    
    public static void previousSmallerElement(int[] array){
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<array.length; i++){
            // while stack is not empty and the top element of the stack is not less the the arr[i] keep remoing the top one 
            while(!s.isEmpty() && s.peek() >= array[i]){
                s.pop();
            }

            // if the stack is empty
            if(s.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(s.peek());
            }
            s.push(array[i]);
        }
    }

    public static void previousGreaterElement(int[] array){
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i< array.length; i++){
            while( !s.isEmpty() && s.peek() <= array[i]){
                s.pop();
            }
            if(s.isEmpty()){
                System.out.println(-1);
            }
            if(!s.isEmpty() && s.peek() > array[i]){
                System.out.println(s.peek());
            }
            s.push(array[i]);
        }
    }



    public static void main(String[] args) {
        int array[]  ={4,10,5,8,20,15,3,11};
        previousGreaterElement(array);        
        
    }
}
