package DataStructureProblems.LinkedList;

/**
 * Created by arun.gupta on 25/04/16.
 */
public class LinkedList {
    Node head;  // head of list

    public void insertNode(Node node){
        Node current = null;
        if(head == null){
            head = node;
        }
        current = head;

        while (current.next != null)
            current = current.next;
        current.next = node;
    }
}
