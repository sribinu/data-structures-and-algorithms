package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1)
            return;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }

    public static void sortDescending(int[] array) {
        if (array == null || array.length <= 1)
            return;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 0, 1, 2};
        sort(array);
        System.out.println(Arrays.toString(array));

        sortDescending(array);
        System.out.println(Arrays.toString(array));
    }
}
