package ashish.btech.dsa.lc;

public class LC10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            while (p.length() > 1) {
                if (p.charAt(1) == '*') {
                    if (p.charAt(0) == s.charAt(0)) {
                        s = s.substring(1);
                    } else {
                        p = p.substring(2);
                    }
                } else {
                    if (p.charAt(0) == s.charAt(0)) {
                        s = s.substring(1);
                        p = p.substring(1);
                    } else {
                        return false;
                    }
                }
            }

            return false;
        }
    }
}
