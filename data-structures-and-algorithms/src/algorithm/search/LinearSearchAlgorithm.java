package algorithm.search;

import java.util.Arrays;

class LinearSearch {
    public static int find(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static int find(String str, char target) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(String str, char target) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }

    public static int[] find(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return new int[] {-1, -1};
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) { // array[i].length -> important logic
                if (array[i][j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static boolean contains(int[][] array, int target) {
        if (array == null) {
            return false;
        }

        for (int[] one : array) {
            for (int element : one) {
                if (element == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class LinearSearchAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 7, 5, 6};
        int target = 1;

        System.out.println(LinearSearch.find(arr, target));
        System.out.println(LinearSearch.find(arr, 8));

        System.out.println(LinearSearch.contains(arr, target));
        System.out.println(LinearSearch.contains(arr, 8));

        String str = "java programming";

        System.out.println(LinearSearch.find(str, 'j'));
        System.out.println(LinearSearch.find(str, 'z'));

        System.out.println(LinearSearch.contains(str, 'j'));
        System.out.println(LinearSearch.contains(str, 'z'));

        int[][] arr2 = {
                {0, 1},
                {4, 5, 6},
                {9}
        };

        System.out.println(Arrays.toString(LinearSearch.find(arr2, 4)));
        System.out.println(Arrays.toString(LinearSearch.find(arr2, 7)));

        System.out.println(LinearSearch.contains(arr2, 4));
        System.out.println(LinearSearch.contains(arr2, 7));
    }
}
