package ashish.btech.dsa.lc.easy;

public class LC14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String common = strs[0];
            for (String str : strs) {
                for (int i = 0; i < Math.min(str.length(), common.length()); i++) {
                    if (str.charAt(i) != common.charAt(i)) {
                        common = common.substring(0, i);
                    }
                }
            }
            return common;
        }
    }
}
