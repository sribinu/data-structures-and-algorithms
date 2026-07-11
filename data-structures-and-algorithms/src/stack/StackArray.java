package stack;

// Fixed allocation of memory
public class StackArray {
    int[] stack;
    int size;
    int top;

    public StackArray(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    // O(1) Time
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = data;
    }

    // O(1) Time
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    // O(1) Time
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // O(1) Time
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());

        System.out.println(stack.isFull());

        stack.display();
    }
}
