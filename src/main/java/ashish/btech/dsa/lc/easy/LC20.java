package ashish.btech.dsa.lc.easy;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> parenthesiStack = new Stack<Character>();
        for (char i : s.toCharArray()) {
            if (i == '[' || i == '(' || i == '{') {
                parenthesiStack.push(i);
            } else {
                if (parenthesiStack.isEmpty()) return false;
                char p = parenthesiStack.pop();
                if ((i == ')' && p != '(') || (i == ']' && p != '[') || (i == '}' && p != '{')) return false;
            }
        }

        return parenthesiStack.isEmpty();
    }

    public static void main(String[] args) {
        LC20 blah = new LC20();
        System.out.println(blah.isValid(")"));
    }
}
