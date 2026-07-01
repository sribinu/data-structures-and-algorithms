package array;

public class Array {
    int[] arr; // array
    int capacity; // size of the array
    int size; // no of elements present in the array

    // create an array via constructor
    public Array(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    // insert an element into an array
    public boolean insert(int index, int element) {
        if (index < 0 || index > size || size >= capacity) {
            System.out.println("Insert failed. Can't insert: " + element);
            return false;
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    // get an element from the array
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't get: Invalid index");
            return -1;
        }
        return arr[index];
    }

    // set an element into the array
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Can't set: Invalid index");
        }
        arr[index] = element;
    }

    // search an element
    public int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }

    // delete an element from the array
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't delete: Invalid index");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array arr1 = new Array(5);
//        System.out.println(arr1.capacity);

        arr1.insert(0, 5);
        arr1.insert(1, 4);
        arr1.insert(1, 7);
        arr1.insert(1, 9);
//        arr1.insert(7, 6);

        arr1.display();

        System.out.println("get: " +  arr1.get(1));
//        System.out.println(arr1.get(4));

        arr1.set(1, 44);

        System.out.println("search: " + arr1.search(5));

        arr1.display();

        arr1.delete(1);

        arr1.display();
    }

}
