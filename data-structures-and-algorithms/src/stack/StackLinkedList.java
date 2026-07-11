package stack;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Dynamic allocation of memory
public class StackLinkedList {
    private Node top;
    private int size;

    public StackLinkedList() {
        top = null;
        size = 0;
    }

    // O(1) Time
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // O(1) Time
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    // O(1) Time
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // O(1) Time
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4); // 4 3 2 1

        System.out.println("Popped: " + stack.pop()); // Output: 4
        System.out.println("Peek: " + stack.peek());  // Output: 3
        System.out.println("Is Empty: " + stack.isEmpty()); // Output: false
        System.out.println("Current Size: " + stack.size()); // Output: 3

        stack.display(); // Output: 3 2 1
    }
}
