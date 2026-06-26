package ashish.btech.dsa;

public class SortingAlgorithms {

    public static int[] insertionSort(int[] nums) {
        for (int a = 1; a < nums.length; a++) {
            int index = a;
            while (index > 0 && nums[index] < nums[index - 1]) {
                int temp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = temp;
                index--;
            }
        }
        return nums;
    }

    public static int[] selectionSort(int[] nums) {
        for (int a = 0; a < nums.length - 1; a++) {
            int smallestNumIndex = a;
            for (int b = a + 1; b < nums.length; b++) {
                if (nums[smallestNumIndex] > nums[b]) smallestNumIndex = b;
            }
            int temp = nums[a];
            nums[a] = nums[smallestNumIndex];
            nums[smallestNumIndex] = temp;
        }
        return nums;
    }

    public static int[] bubbleSort(int[] nums) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int a = 0; a < nums.length - 1; a++) {
                if (nums[a] > nums[a + 1]) {
                    int temp = nums[a];
                    nums[a] = nums[a + 1];
                    nums[a + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    private static void merge(int[] nums, int left, int right, int mid) {
        int[] left_arr = new int[mid - left + 1];
        int[] right_arr = new int[right - mid];

        System.arraycopy(nums, left, left_arr, 0, mid - left + 1);
        System.arraycopy(nums, mid + 1, right_arr, 0, right - mid);

        int i = 0, j = 0, k = left;
        while (i < left_arr.length && j < right_arr.length) {
            if (left_arr[i] <= right_arr[j]) {
                nums[k] = left_arr[i];
                i++;
            } else {
                nums[k] = right_arr[j];
                j++;
            }
            k++;
        }

        while (i < left_arr.length) {
            nums[k] = left_arr[i];
            i++;
            k++;
        }
        while (j < right_arr.length) {
            nums[k] = right_arr[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int polarizedIndex = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                polarizedIndex++;
                int temp = nums[i];
                nums[i] = nums[polarizedIndex];
                nums[polarizedIndex] = temp;
            }
        }
        nums[right] = nums[polarizedIndex + 1];
        nums[polarizedIndex + 1] = pivot;

        return polarizedIndex + 1;
    }

    public static int[] countingSort(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] counting_arr = new int[max + 1];
        for (int num : nums) {
            counting_arr[num]++;
        }
        for (int index = 1; index < counting_arr.length; index++) {
            counting_arr[index] += counting_arr[index - 1];
        }
        int[] counting_sorted_arr = new int[nums.length];
        for (int reversePointer = nums.length - 1; reversePointer >= 0; reversePointer--) {
            counting_sorted_arr[counting_arr[nums[reversePointer]] - 1] = nums[reversePointer];
            counting_arr[nums[reversePointer]]--;
        }
        return counting_sorted_arr;
    }

    public static void heapSort(int[] nums) {
        for (int reversePointer = nums.length - 1; reversePointer > 0; reversePointer--) {
            for (int heapifier = reversePointer; heapifier > 0; heapifier--) {
                if (nums[(heapifier - 1) / 2] < nums[heapifier]) {
                    int temp = nums[heapifier];
                    nums[heapifier] = nums[(heapifier - 1) / 2];
                    nums[(heapifier - 1) / 2] = temp;
                }
            }
            int temp = nums[reversePointer];
            nums[reversePointer] = nums[0];
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {6, 3, 9, 3, 8, 3, 8, 2};
        heapSort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
