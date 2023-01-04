import java.util.Stack;

public class InfoToPostfix {

    public static void infoToPostfix(String exp) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);
            if (ch == '(') {
                s.push(ch);
            } else if (isOperator(ch)) {
                if (s.isEmpty()) {
                    s.push(ch);
                } else if (checkprecedence(s.peek(), ch)) {
                    s.push(ch);
                } else if (!checkprecedence(s.peek(), ch)) {
                    s.pop();
                }
            }else if (ch == ')'){
                System.out.println(s.peek());
                s.pop();
            }else{
                System.out.println(ch);
            }
        }
    }

    }

    private static boolean checkprecedence(Character peek, char ch) {
        return (peek == ch) || peek < ch || peek > ch;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        String expression = "a*b/(d+c)*e";
        infoToPostfix(expression);
    }
}
