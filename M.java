
import java.util.Arrays;

public class M {
    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        mergeSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
    static void mergeSort(int[] array, int low, int high){
        if( high - low <= 1 ) {
            return;
        }
            int mid = (high + low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid, high);

            merge(array, low, mid, high);
        
    }
    static void merge(int[] array, int low, int mid, int high){
        int[] mix = new int[high - low];
        int i  = low;
        int j = mid ;
        int k = 0;

        while( i < mid && j< high){
            if(array[i] < array[j]){
                mix[k] = array[i];
                i++;
            }else{
                mix[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            mix[k] = array[i];
            i++;
            k++;
        }

        while(j < high){
            mix[k] = array[j];
            k++;
            j++;
        }

        for(int l = 0; l < mix.length; l++){
            array[low + l] = mix[l];
        }

    }
}
