import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.zip.Inflater;

public class LambdaExpression {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(15);
        nums.add(52);
        nums.add(34);

        // 1
        nums.forEach((e) -> {
            System.out.println(e);
        });

        // 2
        Consumer<Inflater> method  = (n) -> {
            System.out.println(n);
        };
        
    }
}
