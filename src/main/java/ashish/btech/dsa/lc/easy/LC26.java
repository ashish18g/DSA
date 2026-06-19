package ashish.btech.dsa.lc.easy;

public class LC26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;
        for (int p = 0; p < nums.length; p++) {
            if (nums[k - 1] != nums[p]) k++;
            nums[k - 1] = nums[p];
        }

        return k;
    }

    public void run() {

        int[] i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(i));
    }

    public static void main(String[] args) {
        new LC26().run();
    }
}
