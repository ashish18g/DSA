package ashish.btech.dsa.lc.medium;

public class LC33 {

    public int search(int[] nums, int target, int start, int end) {
        if (start <= end) {

            int midIndex = start + (end - start) / 2;
            if (nums[midIndex] == target) return midIndex;

            if (nums[midIndex] < target) {
                int check = search(nums, target, midIndex + 1, end);
                if (check > -1 || (nums[start] > nums[end] && nums[midIndex] > nums[end])) return check;
                else return search(nums, target, start, midIndex - 1);
            } else {
                int check = search(nums, target, start, midIndex - 1);
                if (check > -1 || (nums[start] > nums[end] && nums[midIndex] < nums[end])) return check;
                else return search(nums, target, midIndex + 1, end);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums[0] == target) return 0;
        if (nums[nums.length - 1] == target) return nums.length - 1;
        return search(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        LC33 blah = new LC33();
        System.out.println(blah.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
