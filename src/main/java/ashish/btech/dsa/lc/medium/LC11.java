package ashish.btech.dsa.lc.medium;

public class LC11 {
    public static int maxArea(int[] height) {
        int maxVolume = 0;
        int right = height.length - 1;
        int left = 0;
        while (left < right) {
            int volume = Math.min(height[left], height[right]) * (right - left);
            if (maxVolume < volume) maxVolume = volume;
            if (height[left] > height[right]) right--;
            else left++;
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        System.out.println(LC11.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
