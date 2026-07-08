package linkedlist;

// Memory size = 8 bytes (prev) + 4 bytes (int data) + 8 bytes (next) = 20 bytes, which is 66.6% more than SLL
class DoublyNode {
    DoublyNode prev;
    int data;
    DoublyNode next;

    public DoublyNode(int data) {
        prev = null;
        this.data = data;
        next = null;
    }
}

public class DoublyLinkedList {
    private DoublyNode head = null;

    // insert at beginning (O(1))
    public void insertAtFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // insert at last (O(n))
    public void insertAtLast(int data) {
        if (head == null) {
            insertAtFirst(data);
            return;
        }

        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        DoublyNode newNode = new DoublyNode(data);
        temp.next = newNode;
        newNode.prev = temp;
    }

    // insert at specific index  (O(n))
    public void insert(int index, int data) {
        if (index < 0) {
            throw new IllegalArgumentException("Index value can't be negative");
        }

        if (index == 0) {
            insertAtFirst(data);
            return;
        }

        DoublyNode temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            throw new IllegalArgumentException("Invalid index");
        }

        DoublyNode newNode = new DoublyNode(data);
        newNode.prev = temp;
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    // delete by value  (O(n))
    public void deleteByValue(int data) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        DoublyNode temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value " + data + " not found in the list.");
            return;
        }

        // temp is the predecessor of the node we want to delete (temp.next)
        DoublyNode target = temp.next;
        temp.next = target.next;

        if (temp.next != null) {
            temp.next.prev = temp;
        }
    }

    // Delete by index  (O(n))
    public void delete(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index can't be negative");

        if (head == null)
            throw new IllegalArgumentException("List is empty");

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        DoublyNode temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            throw new IllegalArgumentException("Invalid index");
        }

        DoublyNode target = temp.next;
        temp.next = target.next;

        if (temp.next != null) {
            temp.next.prev = temp;
        }
    }

    // Search for a value  (O(n))
    public boolean search(int data) {
        DoublyNode temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display list elements forward (O(n))
    public void display() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtFirst(1); // 1
        list.insertAtFirst(11); // 11 1

        list.insertAtLast(2); // 11 1 2
        list.insertAtLast(22); // 11 1 2 22

        list.deleteByValue(2); // 11 1 22

        list.delete(0); // 1 22

        list.delete(1); // 1

        System.out.println(list.search(1)); // true
        System.out.println(list.search(22)); // false

        list.display();
    }
}
