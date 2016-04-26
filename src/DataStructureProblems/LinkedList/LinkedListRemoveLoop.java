package DataStructureProblems.LinkedList;

/**
 * Created by arun.gupta on 25/04/16.
 */
public class LinkedListRemoveLoop {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("Slow Node : "+slow.data);
            System.out.println("Fast Node : "+fast.data);
            System.out.println();
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                System.out.println("**Slow Node : "+slow.data);
                System.out.println("**Fast Node : "+fast.data);
                System.out.println("Loop Size : "+findLoopSize(fast,slow));
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    private int findLoopSize(Node fast, Node slow) {
        int loopSize = 1;
        slow = slow.next;
        while (slow != fast){
            ++loopSize;
            slow = slow.next;
        }
        return loopSize;
    }

    // Function to remove loop
    void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;

        /* Set a pointer to the beging of the Linked List and
         move it one by one to find the first node which is
         part of the Linked List */
        ptr1 = curr;
        while (1 == 1) {

            /* Now start a pointer from loop_node and check if it ever
             reaches ptr2 */
            ptr2 = loop;
            System.out.println("ptr1 : " +ptr1.data);
            System.out.println("ptr2 : " +ptr2.data);
            System.out.println("loop : " +loop.data);
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
                System.out.println("***___ptr2 : " +ptr2.data);
            }

            /* If ptr2 reahced ptr1 then there is a loop. So break the
             loop */
            System.out.println("___ptr2 : " +ptr2.data);
            if (ptr2.next == ptr1) {
                break;
            }

            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }

        /* After the end of loop ptr2 is the last node of the loop. So
         make next of ptr2 as NULL */
        ptr2.next = null;
    }

    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        LinkedListRemoveLoop list = new LinkedListRemoveLoop();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next.next.next.next.next.next = new Node(12);

        Node lastNode  = list.head.next.next.next.next.next.next.next.next.next.next.next;

        list.printList(head);
        // Creating a loop for testing
        System.out.println("Loop Where Connecting :  "+head.next.next.data);
        System.out.println("Loop From Where Connecting :  "+lastNode.data);
        lastNode.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}

// This code has been contributed by Mayank Jaiswal

