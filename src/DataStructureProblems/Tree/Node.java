package DataStructureProblems.Tree;

/**
 * Created by arun.gupta on 25/04/16.
 */
public class Node {
    int data;
    Node left, right;
    int depth;

    public Node(int item) {
        data = item;
        left = right = null;
        depth = 0;
    }
}
