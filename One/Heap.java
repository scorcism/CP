class Heap{

    // Insert in max heap
    private static void Insert(int value, int n, int[] array){
        n = n+1;
        array[n] = value;
        int i = n;

        while(i<l){
            int parent = i / 2;
            if(array[parent] < array[i]){
                swap(array,parent,i);
                i  = parent;
            }else{
                return;
            }
        }
    }
    private static void Delete(int[] A,n){
        A[1] = A[n];
        n = n-1;
        i = 1;
        while(i < n){
            int left = A[2 * i];
            int right = A[2 * i + 1];
            int largest = left > right ? 2 *1 : 2*i+1;

            if(A[i] < A[largest]){
                swap(A,i,largest);
                i = largest;
            }else{
                return;
            }
        }
    }

    public static void swap(int[] array, int first, int second){
        int tmp = array[first];
        array[second] = array[first];
        array[first] = tmp;        
    }

    public static void main(String[] args){


    }    
}