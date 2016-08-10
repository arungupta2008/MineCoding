package CodingProblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by arun.gupta on 04/08/16.
 * input :
 *
 * /**
 * Created by arun.gupta on 02/08/16.
 * <p>
 * Collections.indexOfSubList() method returns the starting position of the first occurrence of the specified target
 * list  within the specified source list, or -1 if there is no such occurrence. -
 *
 * Atlassian
 */



public class SubListIndexFindProblem {

    public static class LinkedListNode{
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    };

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    static int find(LinkedListNode list, LinkedListNode sublist) {
        LinkedListNode curr_list = list;
        Boolean flag = true;
        int index = 0;
        while(curr_list!=null){
            if(curr_list.val.equals(sublist.val)){
                LinkedListNode current_sublist = sublist;
                LinkedListNode saved_list = curr_list;
                while(current_sublist != null){
                    if (!current_sublist.val.equals(curr_list.val)){
                        flag = false;
                        curr_list = saved_list.next;
                        break;
                    }
                    current_sublist = current_sublist.next;
                    curr_list = curr_list.next;
                }
                if(current_sublist == null){
                    flag =true;
                    break;
                }
            } else {
                curr_list = curr_list.next;
            }
            index ++;
        }
        if(flag) {
            return index;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        int _list_size = Integer.parseInt(in.nextLine()), _list_i;
//        String _list_item;
        LinkedListNode _list = null;
//        for(_list_i = 0; _list_i < _list_size; _list_i++) {
//            try {
//                _list_item = in.nextLine();
//            } catch (Exception e) {
//                _list_item = null;
//            }
//            _list = _insert_node_into_singlylinkedlist(_list, _list_item);
//        }

        _list = _insert_node_into_singlylinkedlist(_list,"1");
        _list = _insert_node_into_singlylinkedlist(_list,"2");
        _list = _insert_node_into_singlylinkedlist(_list,"3");
        _list = _insert_node_into_singlylinkedlist(_list,"4");
        _list = _insert_node_into_singlylinkedlist(_list,"5");



        LinkedListNode _sublist = null;
//        _insert_node_into_singlylinkedlist(_sublist, "2");
        _sublist = _insert_node_into_singlylinkedlist(_sublist, "3");
        _sublist = _insert_node_into_singlylinkedlist(_sublist, "4");
//        int _sublist_size = Integer.parseInt(in.nextLine()), _sublist_i;
//        String _sublist_item;
//        for(_sublist_i = 0; _sublist_i < _sublist_size; _sublist_i++) {
//            try {
//                _sublist_item = in.nextLine();
//            } catch (Exception e) {
//                _sublist_item = null;
//            }
//            _sublist = _insert_node_into_singlylinkedlist(_sublist, _sublist_item);
//        }

        System.out.println(find(_list, _sublist));
    }

}
