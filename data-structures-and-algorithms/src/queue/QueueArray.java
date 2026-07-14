package queue;

public class QueueArray {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public QueueArray(int size) {
        this.queue = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    // O(1) Time
    public void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1 && rear == -1) {
            front++;
            queue[++rear] = data;
            return;
        }
        queue[++rear] = data;
    }

    // O(1) Time
    public int dequeue() {
        if (front == -1 || rear == -1 || front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front++];
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
//        queue.enqueue(40);
        queue.display();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.display();
    }
}
