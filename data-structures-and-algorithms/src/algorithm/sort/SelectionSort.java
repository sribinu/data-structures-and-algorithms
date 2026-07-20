package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1)
            return;

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
//            int min = array[i];
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
//                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void sortDescending(int[] array) {
        if (array == null || array.length <= 1)
            return;

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 1, 2, 11};
        sort(array);
        System.out.println(Arrays.toString(array));

        sortDescending(array);
        System.out.println(Arrays.toString(array));
    }
}
