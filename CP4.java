public class CP4 {
    public static void main(String[] args) {
        NumberTheory nt = new NumberTheory();
        int a = 12;
        nt.printBinary(a);
        nt.checkIthSet(a, 1);
        nt.checkIthUnset(a, 1);
        nt.toggleIth(a, 1);
    }
}

class NumberTheory {

    // Decimal to Binary
    public void printBinary(int n) {
        for (int i = 31; i >= 0; --i) {
            System.out.print((n >> i) & 1);
        }
        System.out.println();
    }

    // Check ith bit set or not
    public void checkIthSet(int n, int i) {
        int mask = (1 << i);
        if ((n & mask) != 0) {
            System.out.println("set bit");
        } else {
            System.out.println("unset bit");
        }
    }

    // check ith unset bit
    public void checkIthUnset(int n, int i) {
        int mask = (1<<i);
        if((n&(~mask)) !=0 ){
            System.out.println("unset bit at i");
        }else{
            System.out.println("no unset bit at i");
        }
    }

    // Toggle ith bit
    public void toggleIth(int n, int i){
        int mask = (1<<i);
        int toggled = (n^mask);
        printBinary(toggled);
    }

}
