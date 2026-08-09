package ashish.btech.dsa.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class LC17 {
    List<String> combinations = new ArrayList<String>();
    String[] lettersMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void letterCombi(String digits, String currStr) {
        boolean insertInList = currStr.length() == digits.length() - 1;
        String letters = lettersMap[digits.charAt(currStr.length()) - '0'];

        for (char a : letters.toCharArray()) {
            String newStr = currStr + a;
            if (insertInList) {
                combinations.add(newStr);
            } else {
                letterCombi(digits, newStr);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        letterCombi(digits, "");

        return combinations;
    }

    public static void main(String[] args) {
        LC17 blah = new LC17();
        List<String> letCombi = blah.letterCombinations("2");
        for (String a : letCombi) {
            System.out.println(a);
        }
    }
}
