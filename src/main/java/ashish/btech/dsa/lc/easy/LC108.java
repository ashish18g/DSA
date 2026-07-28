package ashish.btech.dsa.lc.easy;

import java.util.Arrays;
import ashish.btech.dsa.structures.TreeNode;

public class LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        if (nums.length <= 2) return root;
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, (nums.length / 2) + 1, nums.length));
        return root;
    }

    public void run() {
        TreeNode testInput = sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
        System.out.println(testInput);
    }

    public static void main(String[] args) {

        new LC108().run();
    }
}
