package adt;

// ADT (Abstract Data Type)
interface MyStack {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();

}

public class MyArrayStack implements MyStack {
    private int[] arr; // to hold stack data
    private int capacity; // size
    private int top; // index of the top element in the stack

    public MyArrayStack(int size) {
        this.capacity = size;
        arr = new int[size];
        top = -1; // -1 indicates the stack is empty
    }

    // Add an item to the top of the stack
    @Override
    public void push(int item) {
        // check stack overflow
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Can't push: " + item);
            return;
        }

        top++; // increment top, then insert the item at that new index
        arr[top] = item;
        System.out.println("Pushed: " + item);
    }

    // remove and return the top item
    @Override
    public int pop() {
        // check stack underflow
        if (isEmpty()) {
            System.out.println("Stack underflow! The stack is empty");
            return -1;
        }

        // get the item, then decrement top to remove it
        int poppedItem = arr[top];
        top--;

        // Note: We don't actually delete the data in the array.
        // we just move the 'top' pointer down, the old data will be overwritten later with new data.
        return poppedItem;
    }

    // Look at the top item without removing it
    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    // Check if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        MyStack stack = new MyArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.push(4); // Stack Overflow

        System.out.println("Top item: " + stack.peek());

        System.out.println("Popped: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
