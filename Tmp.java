import java.util.*;

class Tmp {

    public static void main(String[] args){
        int[] ar = new int[7];
        Arrays.fill(ar,1);
        System.out.println(Arrays.toString(ar));

        int[] ar2 = {1,2,3,4,5,6,7};

        for(int i = ar2.length - 1; i >= 0 ; i--){
            System.out.print(ar2[i] + " ");
        }
        System.out.println();

        int[] ar3 = new int[5];
        System.out.println(Arrays.toString(ar3));
    }
}