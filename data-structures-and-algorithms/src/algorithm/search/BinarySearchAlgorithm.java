package algorithm.search;

class BinarySearch {
    public static int searchAscending(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public static int search(int[] array, int target) {
        if (array.length == 0)
            return -1;

        int left = 0, right = array.length - 1;

        boolean asc = true;

        if (array[left] > array[right])
            asc = false;

        if (asc) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        } else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    public static int searchUsingRecursion(int[] array, int target) {
        if (array.length == 0)
            return -1;

        return search(array, target, 0, array.length - 1);
    }

    public static int search(int[] array, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right)
            return -1;

        if (array[mid] == target)
            return mid;
        else if (array[mid] > target)
            return search(array, target, left, mid - 1);
        else
            return search(array, target, mid + 1, right);
    }
}

public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;

        System.out.println(BinarySearch.searchAscending(arr, target));
        System.out.println(BinarySearch.searchAscending(arr, 8));

        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(BinarySearch.search(arr2, 4));
        System.out.println(BinarySearch.search(arr2, 9));

        System.out.println(BinarySearch.searchUsingRecursion(arr, 4));
        System.out.println(BinarySearch.searchUsingRecursion(arr, 9));
    }
}
