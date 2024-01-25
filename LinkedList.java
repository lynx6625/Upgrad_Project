import java.util.*;

class LinkedList {
    Node head;
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void rotate(int k) {
        if (k == 0) {
            return;
        }
        Node current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        if (current == null)
            return;

        Node knode = current;
        while (current.next != null)
            current = current.next;
        current.next = head;
        head = knode.next;
        knode.next = null;
    }

    void insert(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(80);
        System.out.println("Given list");
        list.printList();
        list.rotate(4);
        System.out.println("Rotated Linked List");
        list.printList();
    }
}
