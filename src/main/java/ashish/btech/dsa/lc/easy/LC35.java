package ashish.btech.dsa.lc.easy;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        for (int a = 0; a < nums.length; a++) {
            if (nums[a] >= target) return a;
        }
        return nums.length;
    }

    public void run() {
        int[] testInput = {1, 3, 5, 6};
        System.out.println(searchInsert(testInput, 5));
    }

    public static void main(String[] args) {
        new LC35().run();
    }
}
