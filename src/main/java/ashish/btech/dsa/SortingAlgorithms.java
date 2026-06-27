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
        for (int reversePointer = nums.length; reversePointer > 0; reversePointer--) {
            swapped = false;
            for (int a = 0; a < reversePointer - 1; a++) {
                if (nums[a] > nums[a + 1]) {
                    int temp = nums[a];
                    nums[a] = nums[a + 1];
                    nums[a + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
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
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        System.arraycopy(nums, left, leftArr, 0, mid - left + 1);
        System.arraycopy(nums, mid + 1, rightArr, 0, right - mid);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length) {
            nums[k] = rightArr[j];
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
        int[] countingArr = new int[max + 1];
        for (int num : nums) {
            countingArr[num]++;
        }
        for (int index = 1; index < countingArr.length; index++) {
            countingArr[index] += countingArr[index - 1];
        }
        int[] countingSortedArr = new int[nums.length];
        for (int reversePointer = nums.length - 1; reversePointer >= 0; reversePointer--) {
            countingSortedArr[countingArr[nums[reversePointer]] - 1] = nums[reversePointer];
            countingArr[nums[reversePointer]]--;
        }
        return countingSortedArr;
    }

    public static void bubbleDown(int[] nums, int index, int limitIndex) {

        if (((limitIndex > index * 2 + 2 && nums[index * 2 + 1] > nums[index * 2 + 2]) || limitIndex > index * 2 + 1)
                && nums[index] < nums[index * 2 + 1]) {
            int temp = nums[index];
            nums[index] = nums[index * 2 + 1];
            nums[index * 2 + 1] = temp;
            bubbleDown(nums, index * 2 + 1, limitIndex);
        }
        if (limitIndex > index * 2 + 2 && nums[index] < nums[index * 2 + 2]) {
            int temp = nums[index];
            nums[index] = nums[index * 2 + 2];
            nums[index * 2 + 2] = temp;
            index = index * 2 + 2;
            bubbleDown(nums, index, limitIndex);
        }
    }

    public static void heapSort(int[] nums) {
        for (int reversePointer = nums.length - 1; reversePointer > 0; reversePointer--) {
            if (reversePointer == nums.length - 1) {

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
            } else {
                bubbleDown(nums, 0, reversePointer + 1);
                int temp = nums[reversePointer];
                nums[reversePointer] = nums[0];
                nums[0] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {6, 3, 9, 3, 8, 3, 8, 2};
        bubbleSort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
