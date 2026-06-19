package ashish.btech.dsa.lc.easy;

public class LC14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String common = strs[0];
            for (String str : strs) {
                if (str.equals(common)) continue;
                common = common.substring(0, Math.min(str.length(), common.length()));
                for (int i = 0; i < common.length(); i++) {
                    if (str.charAt(i) != common.charAt(i)) {
                        common = common.substring(0, i);
                    }
                }
            }
            return common;
        }
    }

    public void run() {
        Solution sol = new Solution();

        String[] testInput = {"ab", "a"};
        System.out.println(sol.longestCommonPrefix(testInput));
    }

    public static void main(String[] args) {
        new LC14().run();
    }
}
