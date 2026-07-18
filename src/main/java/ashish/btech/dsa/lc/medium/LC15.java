package ashish.btech.dsa.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class LC15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        for (int a = 1; a < nums.length; a++) {
            int index = a;
            while (index > 0 && nums[index] < nums[index - 1]) {
                int temp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = temp;
                index--;
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);

                    triplets.add(triplet);

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum < 0) j++;
                else k--;
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        List<List<Integer>> triplets =
                LC15.threeSum(new int[] {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        System.out.println(triplets);
    }
}
