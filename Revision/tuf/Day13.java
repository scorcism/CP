import java.util.Stack;

public class Day13 {

    // commit template - tuf-day13-questionName
    public static void main(String[] args) {

    }

    
    // Check for balanced parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpening(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatching(s.charAt(i), stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isMatching(char close, Character open) {
        return (open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}');
    }

    private boolean isOpening(char c) {
        return (c == '{' || c == '(' || c == '[');
    }
}
