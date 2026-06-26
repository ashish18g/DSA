package ashish.btech.dsa;

public class SortingAlgorithms {

    public static int[] insertion_sort(int[] listOfNums) {
        for (int a = 1; a < listOfNums.length; a++) {
            int index = a;
            while (index > 0 && listOfNums[index] < listOfNums[index - 1]) {
                listOfNums[index] += listOfNums[index - 1];
                listOfNums[index - 1] = listOfNums[index] - listOfNums[index - 1];
                listOfNums[index] = listOfNums[index] - listOfNums[index - 1];
                index--;
            }
        }
        return listOfNums;
    }

    public static int[] selection_sort(int[] listOfNums) {
        for (int a = 0; a < listOfNums.length - 1; a++) {
            int smallestNumIndex = a + 1;
            for (int b = a + 2; b < listOfNums.length; b++) {
                if (listOfNums[smallestNumIndex] > listOfNums[b]) smallestNumIndex = b;
            }
            listOfNums[a] += listOfNums[smallestNumIndex];
            listOfNums[smallestNumIndex] = listOfNums[a] - listOfNums[smallestNumIndex];
            listOfNums[a] = listOfNums[a] - listOfNums[smallestNumIndex];
        }
        return listOfNums;
    }

    public static int[] bubble_sort(int[] listOfNums) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int a = 0; a < listOfNums.length - 1; a++) {
                if (listOfNums[a] > listOfNums[a + 1]) {
                    listOfNums[a] += listOfNums[a + 1];
                    listOfNums[a + 1] = listOfNums[a] - listOfNums[a + 1];
                    listOfNums[a] = listOfNums[a] - listOfNums[a + 1];
                    swapped = true;
                }
            }
        } while (swapped);
        return listOfNums;
    }

    public static void merge_sort(int[] listOfNums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            merge_sort(listOfNums, left, mid);
            merge_sort(listOfNums, mid + 1, right);
            merge(listOfNums, left, right, mid);
        }
    }

    private static void merge(int[] listOfNums, int left, int right, int mid) {
        int[] left_arr = new int[mid - left + 1];
        int[] right_arr = new int[right - mid];

        System.arraycopy(listOfNums, left, left_arr, 0, mid - left + 1);
        System.arraycopy(listOfNums, mid + 1, right_arr, 0, right - mid);

        int i = 0, j = 0, k = left;
        while (i < left_arr.length && j < right_arr.length) {
            if (left_arr[i] <= right_arr[j]) {
                listOfNums[k] = left_arr[i];
                i++;
            } else {
                listOfNums[k] = right_arr[j];
                j++;
            }
            k++;
        }

        while (i < left_arr.length) {
            listOfNums[k] = left_arr[i];
            i++;
            k++;
        }
        while (j < right_arr.length) {
            listOfNums[k] = right_arr[j];
            j++;
            k++;
        }
    }

    public static void quick_sort(int[] listOfNums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(listOfNums, left, right);
            quick_sort(listOfNums, left, pivotIndex - 1);
            quick_sort(listOfNums, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] listOfNums, int left, int right) {
        int pivot = listOfNums[right];
        int polarizedIndex = left - 1;
        for (int i = left; i < right; i++) {
            if (listOfNums[i] <= pivot) {
                polarizedIndex++;
                int temp = listOfNums[i];
                listOfNums[i] = listOfNums[polarizedIndex];
                listOfNums[polarizedIndex] = temp;
            }
        }
        listOfNums[right] = listOfNums[polarizedIndex + 1];
        listOfNums[polarizedIndex + 1] = pivot;

        return polarizedIndex + 1;
    }

    public static int[] counting_sort(int[] listOfNums) {
        int max = listOfNums[0];
        for (int num : listOfNums) {
            if (num > max) {
                max = num;
            }
        }
        int[] counting_arr = new int[max + 1];
        for (int num : listOfNums) {
            counting_arr[num]++;
        }
        for (int index = 1; index < counting_arr.length; index++) {
            counting_arr[index] += counting_arr[index - 1];
        }
        int[] counting_sorted_arr = new int[listOfNums.length];
        for (int reversePointer = listOfNums.length - 1; reversePointer >= 0; reversePointer--) {
            counting_sorted_arr[counting_arr[listOfNums[reversePointer]] - 1] = listOfNums[reversePointer];
            counting_arr[listOfNums[reversePointer]]--;
        }
        return counting_sorted_arr;
    }

    public static void main(String[] args) {
        int[] array = new int[] {6, 3, 9, 3, 8, 3, 8, 2};
        int[] sorted_arr = counting_sort(array);
        for (int a : sorted_arr) {
            System.out.print(a + " ");
        }
    }
}
