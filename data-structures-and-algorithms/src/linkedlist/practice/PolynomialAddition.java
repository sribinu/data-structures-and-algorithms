package linkedlist.practice;

// polynomial addition using linked list
class Node {
    int coef; // coefficient of the term
    int expo; // exponent (power) of the term
    Node next; // reference to the next term

    public Node(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
        this.next = null;
    }
}

class LinkedList {
    public Node head = null;

    public void insertFirst(int coef, int expo) {
        Node newNode = new Node(coef, expo);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int coef, int expo) {
        if (coef == 0)
            return;

        if (head == null) {
            insertFirst(coef, expo);
            return;
        }

        Node newNode = new Node(coef, expo);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("0");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.expo == 1)
                System.out.print(temp.coef + "x");
            else if (temp.expo != 0)
                System.out.print(temp.coef + "x^" + temp.expo);
            else
                System.out.print(temp.coef);
            temp = temp.next;
            if (temp != null)
                System.out.print(" + ");
        }
        System.out.println();
    }
}

public class PolynomialAddition {

    private static LinkedList addPolynomial(Node p1, Node p2) {
        LinkedList result = new LinkedList();
        while (p1 != null && p2 != null) {
            if (p1.expo == p2.expo) {
                result.insertLast(p1.coef + p2.coef, p1.expo);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.expo > p2.expo) {
                result.insertLast(p1.coef, p1.expo);
                p1 = p1.next;
            } else {
                result.insertLast(p2.coef, p2.expo);
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            result.insertLast(p1.coef, p1.expo);
            p1 = p1.next;
        }
        while (p2 != null) {
            result.insertLast(p2.coef, p2.expo);
            p2 = p2.next;
        }
        return result;
    }


    public static void main(String[] args) {
        // 3x^2 + 4x + 1
        LinkedList p1 = new LinkedList();
        p1.insertLast(3, 2);
        p1.insertLast(4, 1);
        p1.insertLast(1, 0);

        System.out.print("P1 : ");
        p1.display();

        // 4x^2 + 2x
        LinkedList p2 = new LinkedList();
        p2.insertLast(4, 2);
        p2.insertLast(2, 1);

        System.out.print("P2 : ");
        p2.display();

        // add both p1 and p2
        LinkedList sum = addPolynomial(p1.head, p2.head);

        System.out.print("SUM: ");
        sum.display();
    }
}
