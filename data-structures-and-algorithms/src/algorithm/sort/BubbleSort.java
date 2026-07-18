package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length; // no. of elements present in the array

        for (int i = 0; i < n - 1; i++) { // No. of passes = n - 1
            // Optimization: 'n - 1 - i' avoids re-checking already sorted elements at the end
            for (int j = 0; j < n - 1 - i; j++) { // Loop for swapping
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Optimized/Adaptive Bubble Sort
    public static void efficientSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }
        }
    }

    public static void sortDescending(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length; // no. of elements present in the array

        for (int i = 0; i < n - 1; i++) { // No. of passes = n - 1
            for (int j = 0; j < n - 1 - i; j++) { // Loop for swapping
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 10, 1, 0};

        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
        sortDescending(array);
        System.out.println(Arrays.toString(array));

        efficientSort(array);
        int[] array2 = {1, 2, 3, 5, 4};
        efficientSort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}
