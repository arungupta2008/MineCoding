package DataStructureProblems.LinkedList;

/**
 * Created by arun.gupta on 25/04/16.
 */
public class LinkedListInsertionSortedOrder {
    Node head;  // head of list

    /* function to insert a new_node in a list. */
    void sortedInsert(Node new_node) {
        System.out.println("Inserting : "+new_node.data);
        Node current;

         /* Special case for head node */
        if (head == null || head.data >= new_node.data)
        {
            new_node.next = head;
            head = new_node;
        }
        else {

            /* Locate the node before point of insertion. */
            current = head;

            while (current.next != null &&
                    current.next.data < new_node.data)
                current = current.next;

            new_node.next = current.next;
            current.next = new_node;
        }
        printList();
    }

    Node newNode(int data)
    {
        Node x = new Node(data);
        return x;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        LinkedListInsertionSortedOrder llist = new LinkedListInsertionSortedOrder();
        Node new_node;
        new_node = llist.newNode(5);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(10);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(7);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(3);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(1);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(9);
        llist.sortedInsert(new_node);
        System.out.println("Created Linked List");
        llist.printList();
    }
}
/* This code is contributed by Rajat Mishra */
