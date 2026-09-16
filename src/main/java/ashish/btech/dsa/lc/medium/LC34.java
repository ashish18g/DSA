package ashish.btech.dsa.lc.medium;

public class LC34 {

    public int getStart(int[] nums, int target, int start, int end) {
        if (start < end) {
            int midIndx = start + (end - start) / 2;
            if (nums[midIndx] == target) return getStart(nums, target, start, midIndx);
            else if (nums[midIndx] < target) {
                return getStart(nums, target, midIndx + 1, end);
            }
        }
        return start;
    }

    public int getEnd(int[] nums, int target, int start, int end) {
        if (start < end) {
            int midIndx = start + (end - start + 1) / 2;
            if (nums[midIndx] == target) return getEnd(nums, target, midIndx, end);
            else if (nums[midIndx] > target) {
                return getEnd(nums, target, start, midIndx - 1);
            }
        }
        return start;
    }

    public int[] firstNumSearch(int[] nums, int target, int leftIndex, int rightIndex) {
        if (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target)
                return new int[] {
                    getStart(nums, target, leftIndex, midIndex), getEnd(nums, target, midIndex, rightIndex)
                };
            if (nums[midIndex] > target) {
                return firstNumSearch(nums, target, leftIndex, midIndex - 1);
            } else {
                return firstNumSearch(nums, target, midIndex + 1, rightIndex);
            }
        } else return new int[] {-1, -1};
    }

    public int[] searchRange(int[] nums, int target) {
        return firstNumSearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] blah = new int[] {5, 7, 7, 8, 8, 10};
        int target = 8;
        LC34 bruh = new LC34();
        var check = bruh.searchRange(blah, target);
        System.out.println(check);
    }
}
