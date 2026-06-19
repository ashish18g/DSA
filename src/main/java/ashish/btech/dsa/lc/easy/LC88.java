package ashish.btech.dsa.lc.easy;

public class LC88 {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int reversePointerNums2 = n - 1;
        int reversePointerNums1 = m - 1;
        for (int reversePointer = nums1.length - 1; reversePointer >= 0 && reversePointerNums2 >= 0; reversePointer--) {
            if (reversePointerNums1 < 0) {
                nums1[reversePointer] = nums2[reversePointerNums2];
                reversePointerNums2--;
                continue;
            } else nums1[reversePointer] = Math.max(nums1[reversePointerNums1], nums2[reversePointerNums2]);
            if (nums1[reversePointer] == nums2[reversePointerNums2]) {
                reversePointerNums2--;
            } else {
                nums1[reversePointerNums1] = 0;
                reversePointerNums1--;
            }
        }
        return nums1;
    }

    public void run() {
        int[] testInput = merge(new int[] {2, 0}, 1, new int[] {1}, 1);
        for (int digit : testInput) {
            System.out.print(digit + " ");
        }
    }

    public static void main(String[] args) {

        new LC88().run();
    }
}
