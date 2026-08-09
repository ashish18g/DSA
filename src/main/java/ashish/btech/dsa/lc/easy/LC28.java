package ashish.btech.dsa.lc.easy;

public class LC28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        StringBuilder trav = new StringBuilder(haystack.substring(0, needle.length() - 1));

        for (int pos = needle.length() - 1; pos < haystack.length(); pos++) {
            trav.append(haystack.charAt(pos));
            if (needle.equals(trav.toString())) {
                return pos - needle.length() + 1;
            } else {
                trav.deleteCharAt(0);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC28 blah = new LC28();
        System.err.println(blah.strStr("leetcodez", "haf"));
    }
}
