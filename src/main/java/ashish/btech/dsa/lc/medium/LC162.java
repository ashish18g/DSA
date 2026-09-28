package ashish.btech.dsa.lc.medium;

public class LC162 {
    public int findPeakElement(int[] nums) {
        int a = 0;
        while (a < nums.length - 1) {
            if (nums[a] < nums[a + 1]) a++;
            else return a;
        }
        return a;
    }
}
