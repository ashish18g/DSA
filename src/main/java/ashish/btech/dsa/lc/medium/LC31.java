package ashish.btech.dsa.lc.medium;

public class LC31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int pivotIndx = nums.length - 2;
        while (pivotIndx >= 0 && nums[pivotIndx] >= nums[pivotIndx + 1]) {
            pivotIndx--;
        }
        if (pivotIndx >= 0) {
            int swap = nums.length - 1;
            while (swap >= 0 && nums[swap] <= nums[pivotIndx]) {
                swap--;
            }
            if (swap >= 0) {
                int temp = nums[pivotIndx];
                nums[pivotIndx] = nums[swap];
                nums[swap] = temp;
            }
        }
        pivotIndx++;

        // reversing the later indices
        for (int swapperIndx = nums.length - 1; swapperIndx > pivotIndx; swapperIndx--) {
            int temp = nums[swapperIndx];
            nums[swapperIndx] = nums[pivotIndx];
            nums[pivotIndx] = temp;

            pivotIndx++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1};
        LC31.nextPermutation(nums);
        for (int a : nums) {
            System.out.print(a + ", ");
        }
    }
}
