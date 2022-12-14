
class CGA <T extends Number> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // Also working as an index

    public CGA {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return size == data.length;
    }

    private void resize(){
        Object [] tmp = new Object[data.length * 2];

        for(int i = 0; i< data.length ; i++){
            tmp[i] = data[i];
        }
        data = tmp;
    }

    public T remove() {
        T ele =(T)(data[size--]);
        return ele;
    }

    private T get(int index){
        return (T)data[index];
    }

    private int size(){
        return size;
    }

    private void set(int index, T value){
        data[index] = value;       
    }


    public String toString() {
        return "data: " + Arrays.toString(data) ;
    }

}

public class CustomGenericArrayList{
    // Here obejct is above T
    public static void main(String[] args){
        CGA<Integer> a = new CGA<>();
        a.add(45);
        for(int i = 0; i< 14; i++){
            a.add(i*2);
        }

        System.out.println(a);

    }

}