package ashish.btech.dsa;

public class SearchAlgorithms {

    public static int binarySearch(int[] nums, int target, int leftIndex, int rightIndex) {
        if (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) return midIndex;
            if (nums[midIndex] > target) {
                return binarySearch(nums, target, leftIndex, midIndex - 1);
            } else {
                return binarySearch(nums, target, midIndex + 1, rightIndex);
            }
        } else return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int jumpSearch(int[] nums, int target) {
        int step = (int) (Math.sqrt(nums.length));
        int index;
        for (index = 0; nums[Math.min(index, nums.length - 1)] <= target; index += step) {
            index = Math.min(index, nums.length - 1);
            if (nums[index] == target) return index;
        }

        index = Math.min(index, nums.length - 1);
        for (; step > 0; step--) {
            if (index - step >= 0 && nums[index - step] == target) return index - step;
        }
        return -1;
    }

    public static int interpolationSearch(int[] nums, int target, int low, int high) {
        if (high < low || high >= nums.length) return -1;
        if (nums[low] == nums[high]) {
            return nums[low] == target ? low : -1;
        }
        int interpol = low + (((target - nums[low]) * (high - low)) / (nums[high] - nums[low]));
        if (interpol < low || interpol > high) return -1;
        if (nums[interpol] == target) return interpol;
        if (nums[interpol] > target) return interpolationSearch(nums, target, low, interpol - 1);
        else return interpolationSearch(nums, target, interpol + 1, high);
    }

    public static int interpolationSearch(int[] nums, int target) {
        return interpolationSearch(nums, target, 0, nums.length - 1);
    }

    public static int exponentialSearch(int[] nums, int target) {
        switch (nums.length) {
            case 0:
                return -1;
            case 1:
                return nums[0] == target ? 0 : -1;
            default:
                int bound = 1;
                while (bound < nums.length && nums[bound] < target) {
                    bound = bound * 2;
                }
                bound = Math.min(nums.length - 1, bound);
                return binarySearch(nums, target, bound / 2, bound);
        }
    }

    public static int[] getFibSet(int n) {
        int fb1 = 1;
        int fb2 = 2;
        while (n >= fb2) {
            int temp = fb2;
            fb2 += fb1;
            fb1 = temp;
        }
        return new int[] {fb2, fb1};
    }

    public static int fibonacciSearch(int[] nums, int target) {
        int current = 0, offset = -1;
        int[] fb = getFibSet(nums.length);
        while (fb[0] > 1) {
            current = Math.min(offset + fb[0] - fb[1], nums.length - 1);
            if (nums[current] == target) return current;
            else if (nums[current] < target) offset = current;
            fb[1] = fb[0] - fb[1];
            fb[0] = fb[0] - fb[1];
        }
        return -1;
    }

    public static int ternarySearch(int[] nums, int target, int left, int right) {

        if (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (nums[mid1] >= target) {
                if (nums[mid1] == target) return mid1;
                return ternarySearch(nums, target, left, mid1 - 1);
            }
            if (nums[mid2] >= target) {
                if (nums[mid2] == target) return mid2;
                return ternarySearch(nums, target, mid1 + 1, mid2 - 1);
            }
            return ternarySearch(nums, target, mid2 + 1, right);
        }
        return -1;
    }

    public static int ternarySearch(int[] nums, int target) {
        return ternarySearch(nums, target, 0, nums.length - 1);
    }

    public static int BSTsearch(int[] bstNums, int target) {
        int index = 0;
        while (index < bstNums.length) {
            if (bstNums[index] == target) return index;
            else if (bstNums[index] < target) {
                index = 2 * index + 2;
            } else {
                index = 2 * index + 1;
            }
        }
        return -1;
    }

    public static int DFSearch(int[] nums, int target, int index) {
        if (index >= nums.length) return -1;
        if (nums[index] == target) return index;
        int targetIndx = DFSearch(nums, target, index * 2 + 1);
        if (targetIndx > 0) return targetIndx;
        return DFSearch(nums, target, index * 2 + 2);
    }

    public static int DFSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return DFSearch(nums, target, 0);
    }

    public static void main(String[] args) {
        int[] nums = {15, 9, 22, 5, 12, 18, 27, 3, 7, 10, 14, 20};
        System.out.println(DFSearch(nums, 10));
    }
}
