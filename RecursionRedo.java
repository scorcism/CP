import java.util.ArrayList;


public class RecursionRedo {

    public static void main(String[] args) {

        Subsequences sub = new Subsequences();
        // sub.printSubsequences(new int[] {1,2,3});
    }
}

class Subsequences{
    // take not take bases

    public  void printSubsequences(int[] arr){
        /*
         * @url: notion: https://www.notion.so/03355ad457734dd798a489e800bf396a?v=f1de444a07444ed48b75dcf8d55592f5&p=e3c06129112e4d29b14450efb261650d&pm=s
         */
        // T.C: 2 ^ n-> coz we have to make choice for each elemets
        // S.C: -> O(n)
        printsubs(arr, 0, new ArrayList<>());
    }

    void printsubs(int[] arr, int i, ArrayList<Integer> list){
        if(i >=arr.length){
            System.out.println(list);
            return;
        }
        // add current index element to list
        list.add(arr[i]);
        // call for take
        printsubs(arr, i+1, list);

        // remove the last added one to perform not take
        list.remove(list.size()-1);

        // call for not take
        printsubs(arr, i+1, list);

    }
}


