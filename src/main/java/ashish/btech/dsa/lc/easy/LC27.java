package ashish.btech.dsa.lc.easy;

public class LC27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) return 0;
        int k = 0;
        for (int a = nums.length - 1; a > 0 && k != a; a--) {
            if (nums[k] != val) {
                k++;
                a++;
            } else if (nums[a] != val) {
                nums[k] = nums[a];
                nums[a] = val;
            }
        }
        return k + (nums[k] != val ? 1 : 0);
    }

    public void run() {
        int[] testInput = {1};
        System.out.println(removeElement(testInput, 1));
    }

    public static void main(String[] args) {
        new LC27().run();
    }
}
