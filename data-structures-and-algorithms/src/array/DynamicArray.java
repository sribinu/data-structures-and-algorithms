package array;

public class DynamicArray {
    int[] arr; // raw array
    int capacity; // maximum size of the array
    int size; // no of elements currently present in the array

    // create an array via constructor
    // Worst-Case Time Complexity: O(n) (when shifting is required or resize occurs)
    // Amortized Time Complexity at the end: O(1)
    public DynamicArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0; // starts empty
    }

    // insert an element into an array (O(n) time)
    public boolean insert(int index, int element) {
        // Safety check: prevent out-of-bounds or exceeding capacity
        if (index < 0 || index > size) {
            System.out.println("Insert failed. Can't insert: " + element);
            return false;
        }

        // check if array is full
        if (size >= capacity) {
            resize(); // automatically grow physical memory
        }

        // shift elements to the RIGHT to make space
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    // get an element from the array (O(1) Time)
    public int get(int index) {
        // Safety check: Ensure the index actually holds data
        if (index < 0 || index >= size) {
            System.out.println("Can't get: Invalid index");
            return -1;
        }
        return arr[index];
    }

    // set an element into the array (O(1) Time)
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Can't set: Invalid index");
        }
        arr[index] = element;
    }

    // search for an element (O(n) Time)
    public int search(int element) {
        // iterate only through occupied rooms (size), not capacity
        for (int i = 0; i < size; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1; // not found
    }

    // delete an element from the array (O(n) Time)
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't delete: Invalid index");
            return false;
        }
        // shift elements to the LEFT to fill the gap
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    // Grow the array capacity by a factor of 2 (O(n) Time to copy)
    public void resize() {
        int newCapacity = 2 * capacity;
        // create a new array
        int[] newArr = new int[newCapacity];
        // copy all the elements from the existing array into this new array
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        // replace the array
        arr = newArr; // Java Garbage Collection automatically dereference `arr' and remove it
        capacity = newCapacity;
    }

    // display the array elements
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray arr1 = new DynamicArray(5);
        System.out.println("Initial capacity of the array: " + arr1.capacity);

        arr1.insert(0, 5);
        arr1.insert(1, 4);
        arr1.insert(1, 7);
        arr1.insert(1, 9);
        arr1.insert(2, 6);
        arr1.insert(2, 8);

        System.out.println("Updated capacity of the array: " + arr1.capacity);

        arr1.display(); // Output: 5 9 7 4

        System.out.println("get: " +  arr1.get(1)); // Output: 9
//        System.out.println(arr1.get(4));

        arr1.set(1, 44);

        System.out.println("search: " + arr1.search(5)); // Output: 0

        arr1.display(); // Output: 5 44 7 4

        arr1.delete(1);

        arr1.display(); // Output: 5 7 4
    }
}