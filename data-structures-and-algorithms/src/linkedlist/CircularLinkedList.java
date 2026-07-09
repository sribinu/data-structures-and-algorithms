package linkedlist;

public class CircularLinkedList<T> {

    // nested Node class utilizing Generics
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    // Insert at the beginning: O(1) Time
    public void insertFirst(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        }
        newNode.next = tail.next;
        tail.next = newNode;
    }

    // Insert at the end: O(1) Time
    public void insertLast(T data) {
        if (tail == null) {
            insertFirst(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    // Delete from the beginning: O(1) Time
    public void deleteFirst() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        if (tail.next == tail) {
            tail = null;
            return;
        }
        tail.next = tail.next.next;
    }

    // Delete from the end: O(n) Time
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        if (tail.next == tail) {
            tail = null;
            return;
        }
        Node temp = tail;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        tail = temp;
    }

    public void displayFromTail() {
        Node temp = tail;
        if (temp != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != tail);
        }
        System.out.println();
    }

    public void display() {
        Node temp = tail;
        if (temp != null) {
            do {
                temp = temp.next;
                System.out.print(temp.data + " ");
            } while (temp.next != tail.next);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.insertFirst(1); // 1
        list.insertFirst(2); // 2 1
        list.insertFirst(3); // 3 2 1
        list.insertFirst(4); // 4 3 2 1
        list.insertFirst(5); // 5 4 3 2 1

        list.insertLast(6); // 5 4 3 2 1 6
        list.insertLast(7); // 5 4 3 2 1 6 7

        list.deleteFirst();

        list.displayFromTail();  // Expected: 7 4 3 2 1 6

        list.deleteFirst();

        list.display();  // Expected: 3 2 1 6 7

        list.deleteLast();

        list.display();  // Expected: 3 2 1 6
    }
}
