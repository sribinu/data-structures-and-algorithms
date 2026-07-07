package linkedlist;

import java.util.Objects;

class DynamicNode<T> {
    T element;
    DynamicNode<T> next;

    public DynamicNode(T element) {
        this.element = element;
        next = null;
    }
}

// EC - Edge Case
public class SinglyLinkedList<T> {
    private DynamicNode<T> head = null; // first element of the list

    // insert at beginning
    public boolean insertFirst(T element) {
        DynamicNode<T> newNode = new DynamicNode<>(element);
        newNode.next = head;
        head = newNode;
        return true;
    }

    // insert at end
    public boolean insertLast(T element) {
        // EC: if list is empty
        if (head == null) {
            return insertFirst(element);
        }

        DynamicNode<T> newNode = new DynamicNode<>(element);
        DynamicNode<T> temp = head; // backup
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return true;
    }

    public boolean add(T element) {
        return insertLast(element);
    }

    // insert at index
    public boolean insert(int index, T element) {
        // EC: if index is negative
        if (index < 0)
            throw new IllegalArgumentException("Index value can't be negative");

        // EC: if index is 0 - head
        if (index == 0) {
            return insertFirst(element);
        }

        DynamicNode<T> temp = head;

        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        // EC: if index not found
        if (temp == null)
            throw new IllegalArgumentException("Index not found");

        DynamicNode<T> newNode = new DynamicNode<>(element);
        newNode.next = temp.next;
        temp.next = newNode;
        return true;
    }

    public boolean delete(int index) {
        // EC: If head is null
        if (head == null)
            throw new IllegalArgumentException("List is empty");

        // EC: If index is negative
        if (index < 0)
            throw new IllegalArgumentException("Index value is negative");

        // EC: If index is 0
        if (index == 0) {
            head = head.next;
            return true;
        }

        DynamicNode<T> temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        // EC: If index not found
        if (temp == null || temp.next == null)
            throw new IllegalArgumentException("Index not found");

        temp.next = temp.next.next;
        return true;
    }

    public boolean delete(T element) {
        // EC: If head is null
        if (head == null)
            throw new IllegalArgumentException("List is empty");

        // EC: If element is in head
        if (Objects.equals(head.element, element)) {
            head = head.next;
            return true;
        }

        DynamicNode<T> temp = head;
        while(temp.next != null && !Objects.equals(temp.next.element, element)) {
                temp = temp.next;
        }

        if (temp.next == null) {
            return false;
        }

        temp.next = temp.next.next;
        return true;
    }

    public boolean search(T element) {
        DynamicNode<T> temp = head;
        while(temp != null) {
            if (Objects.equals(temp.element, element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void reverse() {
        DynamicNode<T> prev = null;
        DynamicNode<T> current = head;
        DynamicNode<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void display() {
        DynamicNode<T> temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.insertFirst(1); // 1
        list.insertFirst(2); // 2 1

        list.insertLast(3); // 2 1 3
        list.insertLast(4); // 2 1 3 4

        list.insert(2, 5); // 2 1 5 3 4

        list.delete(3); // 2 1 5 4

        list.delete(Integer.valueOf(2)); // 1 5 4

        System.out.println(list.search(3)); // false
        System.out.println(list.search(5)); // true

        list.display();

        list.reverse(); // 4 5 1

        list.display();
    }
}
