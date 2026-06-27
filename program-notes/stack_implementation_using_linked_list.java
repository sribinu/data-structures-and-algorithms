// 1. The ADT (Abstract Data Type) - The "What"
// (Duplicated here so this file runs independently)
interface MyStack {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
}

// 2. The Data Structure - The "How"
public class MyLinkedListStack implements MyStack {
    
    // An inner class representing a single element (Node) in the Linked List
    private class Node {
        int data;       // The actual value
        Node next;      // The reference (pointer) to the next node below it

        // Constructor for the Node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Instead of an array and an index, we just need a pointer to the top Node
    private Node top; 

    // Constructor to initialize an empty stack
    public MyLinkedListStack() {
        this.top = null; // null means the stack is empty
    }

    // Add an item to the top of the stack (O(1) Time)
    @Override
    public void push(int item) {
        // 1. Create a new Node holding the data
        Node newNode = new Node(item);
        
        // 2. Make the new Node point to the current top Node
        newNode.next = top;
        
        // 3. Update the 'top' pointer to be this new Node
        top = newNode;
        
        System.out.println("Pushed: " + item);
        // Notice there is NO "Stack Overflow" check! 
        // It can grow as large as the Java Heap memory allows.
    }

    // Remove and return the top item (O(1) Time)
    @Override
    public int pop() {
        // EXAM TERM: "Stack Underflow" - Still possible if the stack is empty
        if (isEmpty()) {
            System.out.println("Stack Underflow! The stack is empty.");
            return -1; 
        }
        
        // 1. Get the data from the top Node
        int poppedItem = top.data;
        
        // 2. Move the 'top' pointer to the next Node down
        top = top.next;
        
        // In Java, the old top Node is now "unreachable" and the Garbage Collector 
        // will automatically clean it up to free memory!
        return poppedItem;
    }

    // Look at the top item without removing it (O(1) Time)
    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    // Check if the stack is empty (O(1) Time)
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Main method to test our Dynamic Data Structure
    public static void main(String[] args) {
        MyLinkedListStack dynamicStack = new MyLinkedListStack();

        // We can push as many items as we want now!
        dynamicStack.push(10);
        dynamicStack.push(20);
        dynamicStack.push(30);
        dynamicStack.push(40); 
        dynamicStack.push(50); 

        System.out.println("Top item is: " + dynamicStack.peek()); // Should be 50

        System.out.println("Popped: " + dynamicStack.pop()); // Removes 50
        System.out.println("Popped: " + dynamicStack.pop()); // Removes 40

        System.out.println("Is stack empty? " + dynamicStack.isEmpty()); // False
    }
}