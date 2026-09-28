package ashish.btech.dsa.hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumber {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = arr.get(i + 1) - arr.get(i);

            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            } else if (diff == minDiff) {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            }
        }

        return result;
    }

    public String sortString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String lower = s.toLowerCase();

        int[] counts = new int[256];
        for (int i = 0; i < lower.length(); i++) {
            counts[lower.charAt(i)]++;
        }

        StringBuilder sorted = new StringBuilder(lower.length());
        for (int ch = 0; ch < counts.length; ch++) {
            while (counts[ch] > 0) {
                sorted.append((char) ch);
                counts[ch]--;
            }
        }

        return sorted.toString();
    }

    public void sort012(int[] arr) {
        // code here
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static long inversionCount(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in left subarray (from i to mid) are greater than arr[j]
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
