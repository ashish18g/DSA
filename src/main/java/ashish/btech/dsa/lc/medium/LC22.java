package ashish.btech.dsa.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class LC22 {

    public void backtrack(
            List<String> listParenthesis, String currentString, int OpenBraceCount, int CloseBraceCount, int n) {
        if (currentString.length() == 2 * n) {
            listParenthesis.add(currentString);
            return;
        }

        if (OpenBraceCount < n) {
            backtrack(listParenthesis, currentString + "(", OpenBraceCount + 1, CloseBraceCount, n);
        }

        if (CloseBraceCount < OpenBraceCount) {
            backtrack(listParenthesis, currentString + ")", OpenBraceCount, CloseBraceCount + 1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> generatedParenthesis = new ArrayList<String>();
        backtrack(generatedParenthesis, "", 0, 0, n);
        return generatedParenthesis;
    }

    public boolean checkList(List<String> parenthesis) {
        for (int i = 0; i < parenthesis.size() - 1; i++) {
            for (int j = 0; j < parenthesis.size(); j++) {
                if (i != j && parenthesis.get(i).equals(parenthesis.get(j))) {
                    System.out.println("i:" + i + "\nj: " + j);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC22 blah = new LC22();
        List<String> parenthesis = blah.generateParenthesis(3);
        for (int i = 0; i < parenthesis.size(); i++) {
            System.out.println(parenthesis.get(i));
        }
        System.out.println(blah.checkList(parenthesis));
    }
}
