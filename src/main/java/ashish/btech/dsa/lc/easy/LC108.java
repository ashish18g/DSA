package ashish.btech.dsa.lc.easy;

import java.util.Arrays;

public class LC108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
