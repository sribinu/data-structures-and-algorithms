package array;

public class GenericArray<T> {
    private Object[] arr;
    private int capacity;
    private int size;

    public GenericArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }

        arr = new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void add(T element) {
        insert(size, element);
    }

    public void insert(int index, T element) {
        checkPositionIndex(index);

        if (size >= capacity) {
            resize();
        }

        for (int i = index; i < size; i++) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkElementIndex(index);
        return (T) arr[index];
    }

    public void set(int index, T element) {
        checkElementIndex(index);
        arr[index] = element;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Can't delete. Invalid index");
        }

        for (int i = index; i < size -1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public int search(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        capacity = (capacity == 0) ? 1 : capacity * 2;
        Object[] newArr = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    public static void main(String[] args) {
        GenericArray<String> list = new GenericArray<>(3);

        System.out.println("Capacity : " + list.capacity());
        System.out.println("Size     : " + list.size());

        list.add("Sam");
        list.add("Adam");
        list.add("John");

        System.out.println(list);

        list.insert(2, "David");

        System.out.println(list);

        System.out.println("Capacity : " + list.capacity());

        System.out.println("Get(1) : " + list.get(1));

        list.set(1, "Eve");

        System.out.println(list);

        System.out.println(list);

        System.out.println("Size : " + list.size());

        System.out.println(list);

        System.out.println("Empty : " + list.isEmpty());

    }
}
