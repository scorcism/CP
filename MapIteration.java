import java.util.Map;
import java.util.HashMap;

public class MapIteration {
    public static void main(String[] args) {

        Map<String, String> gfg = new HashMap<String, String>();

        // enter name/url pair
        gfg.put("GFG", "geeksforgeeks.org");
        gfg.put("Practice", "practice.geeksforgeeks.org");
        gfg.put("Code", "code.geeksforgeeks.org");
        gfg.put("Quiz", "www.geeksforgeeks.org");

        for (Map.Entry<String, String> entry : gfg.entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }

        System.out.println("***********");
        // using keySet() for iteration over keys
        for (String name : gfg.keySet())
            System.out.println("key: " + name);

        // using values() for iteration over values
        for (String url : gfg.values())
            System.out.println("value: " + url);
    }
}