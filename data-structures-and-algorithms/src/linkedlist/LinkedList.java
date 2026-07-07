package linkedlist;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null; // default to pointing to nothing
    }
}

// Singly LinkedList - a data and a pointer reference of next node
public class LinkedList {
    private Node head = null; // very first node in the list

    // insert at beginning (O(1))
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // insert at end (O(n))
    public void insertAtEnd(int data) {
        // Edge Case: If list is empty
        if (head == null) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // insert at index (O(n)
    // insert at index (O(n)
    public void insertAtIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        // traverse to find the (index - 1)-th node
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);
        // 1. Connect new node to the rest of the list first
        newNode.next = temp.next;
        // 2. Point predecessor to the new node
        temp.next = newNode;
    }

    // delete by value (O(n))
    public void delete(int data) {
        if (head == null) {
            System.out.println("Data not found");
            return;
        }
        // Edge Case: If target is the head node
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Data not found");
            return;
        }
        // Bypass target node: Point predecessor's next to the target's next
        temp.next = temp.next.next;
    }

    // delete by index (O(n))
    public void deleteByIndex(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Data not found");
            return;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int data) {
         Node temp = head;
         while (temp != null) {
             if (temp.data == data)
                 return true;
             temp = temp.next;
         }
         return false;
    }

    // reverse the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev; // reverse the pointer
            prev = current;
            current = next;
        }

        head = prev;
    }

    // display data
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtBeginning(1); // 1 -> null
        list.insertAtBeginning(2); // 2 -> 1 -> null
        list.insertAtBeginning(3); // 3 -> 2 -> 1 -> null

        list.insertAtEnd(4); // 3 -> 2 -> 1 -> 4 -> null

        list.insertAtIndex(2, 5); // 3 -> 2 -> 5 -> 1 -> 4 -> null

        list.delete(5); // 3 -> 2 -> 1 -> 4 -> null

        list.deleteByIndex(0); // 2 -> 1 -> 4 -> null

        System.out.println(list.search(4)); // Expected Output: true
        System.out.println(list.search(5)); // Expected Output: false

        list.display(); // Expected Output: 2 -> 1 -> 4 -> null

        list.reverse(); // 4 -> 1 -> 2 -> null

        list.display();

        list.reverse(); // 2 -> 1 -> 4 -> null

        list.display();
    }
}