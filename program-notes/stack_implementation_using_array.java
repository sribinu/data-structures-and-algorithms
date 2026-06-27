// 1. The ADT (Abstract Data Type) - The "What"
interface MyStack {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
}

// 2. The Data Structure - The "How"
public class MyArrayStack implements MyStack {
    private int[] arr;      // The array to hold our stack data
    private int top;        // The index of the top element
    private int capacity;   // The maximum size of the stack

    // Constructor to initialize the stack
    public MyArrayStack(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.top = -1; // -1 indicates the stack is completely empty
    }

    // Add an item to the top of the stack
    @Override
    public void push(int item) {
        // EXAM TERM: "Stack Overflow" - Trying to push into a full stack
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push " + item);
            return;
        }
        // Increment top FIRST, then insert the item at that new index
        top++;
        arr[top] = item;
        System.out.println("Pushed: " + item);
    }

    // Remove and return the top item
    @Override
    public int pop() {
        // EXAM TERM: "Stack Underflow" - Trying to pop from an empty stack
        if (isEmpty()) {
            System.out.println("Stack Underflow! The stack is empty.");
            return -1; // Returning -1 as an error code (in production, throw an Exception)
        }
        // Get the item, THEN decrement top to "remove" it
        int poppedItem = arr[top];
        top--;
        
        // Note: We don't actually delete the data in the array. 
        // We just move the 'top' pointer down. The old data will be overwritten later.
        return poppedItem;
    }

    // Look at the top item without removing it
    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return arr[top];
    }

    // Check if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    // Main method to test our Data Structure
    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(3); // Create a stack of size 3

        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // This will trigger a Stack Overflow!
        stack.push(40); 

        System.out.println("Top item is: " + stack.peek()); // Should be 30

        System.out.println("Popped: " + stack.pop()); // Removes 30
        System.out.println("Popped: " + stack.pop()); // Removes 20

        System.out.println("Is stack empty? " + stack.isEmpty()); // False (10 is still there)
    }
}