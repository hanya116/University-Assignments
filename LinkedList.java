public class LinkedList {
    // ===== Inner Node class =====
    // Each Node holds data and a reference to the next Node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {

        // ===== STEP 1: Create 5 separate nodes =====
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();

        // ===== STEP 2: Assign data values =====
        n1.data = 31;
        n2.data = 6;
        n3.data = 15;
        n4.data = 44;
        n5.data = 10;
        
        // ===== STEP 3: Link nodes together =====
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;  // last node should point to null

        Node head = n1;

        System.out.println("Original Linked List:");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println(); 

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    // swap only data (not links)
                    int t = i.data;
                    i.data = j.data;
                    j.data = t;
                }
            }
        }
        System.out.println("Sorted Linked List:");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }
}