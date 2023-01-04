import java.util.Stack;

public class InfoToPostfix {

    public static void infoToPostfix(String exp) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);
            if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                System.out.println(s.peek());
                s.pop();
            } else if (isOperator(ch)) {
                if (s.isEmpty()) {
                    s.push(ch);
                }else{
                    if(checkprecedence(ch) > checkprecedence(s.peek())){
                        s.push(ch);
                    }else{
                        if(!(checkprecedence(ch) > checkprecedence(s.peek()))){
                            System.out.println(s.peek());
                            s.pop();
                        }
                    }
                }
            } else {
                System.out.println(ch);
            }
        }
        System.out.println(s.peek());

    }

    private static int checkprecedence(char ch) {
        if (ch == '*' || ch == '/') {
            return 3;
        } else if (ch == '+' || ch == '-') {
            return 2;
        } else
            return 0;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        String expression = "a*b/(d+c)*e";
        String expression2 = "a-b/c*d*e+f";
        infoToPostfix(expression2);
    }
}
