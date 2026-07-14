package queue;

public class EfficientQueueArray {
    int[] queue;
    int size;
    int rear;

    public EfficientQueueArray(int size) {
        queue = new int[size];
        this.size = size;
        rear = -1;
    }

    // O(1) Time
    public void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = data;
    }

    // O(n) Time
    public int dequeue() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int temp = queue[0];
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        return temp;
    }

    public void display() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EfficientQueueArray queue = new EfficientQueueArray(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.display();
    }
}
