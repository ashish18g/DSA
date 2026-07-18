package ashish.btech.dsa.lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                for (int c = b + 1; c < n - 1; c++) {
                    if (c > b + 1 && nums[c] == nums[c - 1]) continue;
                    for (int d = c + 1; d < n; d++) {
                        if (d > c + 1 && nums[d] == nums[d - 1]) continue;
                        if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                            List<Integer> quadruplet = new ArrayList<Integer>();
                            quadruplet.add(nums[a]);
                            quadruplet.add(nums[b]);
                            quadruplet.add(nums[c]);
                            quadruplet.add(nums[d]);

                            quadruplets.add(quadruplet);
                            n = d + 1;
                            break;
                        }
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }
}
