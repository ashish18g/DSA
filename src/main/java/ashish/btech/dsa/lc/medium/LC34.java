package ashish.btech.dsa.lc.medium;

public class LC34 {

    public int searchEnd(int[] nums, int target, int start, int end) {
        if (start < end) {
            int midIndx = start + (end - start) / 2;
            if (nums[midIndx] == target) return searchEnd(nums, target, start, midIndx);
        }
        return -1;
    }

    public static void main(String[] args) {
        LC34 blah = new LC34();
        System.out.println();
    }
}
