import java.util.*;


public class CustomArrayList{

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // Also working as an index

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return size == data.length;
    }

    private void resize(){
        int [] tmp = new int[data.length * 2];

        for(int i = 0; i< data.length ; i++){
            tmp[i] = data[i];
        }
        data = tmp;
    }

    public int remove() {
        int ele = data[size--];
        return ele;
    }

    private int get(int index){
        return data[index];
    }

    private int size(){
        return size;
    }

    private void set(int index, int value){
        data[index] = value;       
    }


    public String toString() {
        return "data: " + Arrays.toString(data) ;
    }

    public static void main(String[] args){
        
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public static int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    public static void setDEFAULT_SIZE(int dEFAULT_SIZE) {
        DEFAULT_SIZE = dEFAULT_SIZE;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}