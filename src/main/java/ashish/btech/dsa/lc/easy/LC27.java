package ashish.btech.dsa.lc.easy;

public class LC27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) return 0;
        int k = 0;
        int a = nums.length - 1;
        while (k <= a) {
            if (nums[k] != val) {
                k++;
                continue;
            } else if (nums[a] != val) {
                nums[k] = nums[a];
                nums[a] = val;
                k++;
            }
            a--;
        }
        return k;
    }

    public void run() {
        int[] testInput = {1};
        System.out.println(removeElement(testInput, 1));
    }

    public static void main(String[] args) {
        new LC27().run();
    }
}
