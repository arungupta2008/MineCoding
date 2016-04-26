package DataStructureProblems.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by arun.gupta on 25/04/16.
 */
public class BinaryTreeMinimumDepth {

    Node root;

    public static void main(String args[]) {

        BinaryTreeMinimumDepth tree = new BinaryTreeMinimumDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.right.left = new Node(8);

        System.out.println("The minimum depth of binary tree is : " + tree.minimumDepth(tree.root));
    }

    private int minimumDepth(Node root) {
        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (1 == 1) {
            Node node = queue.remove();
            System.out.println("Processing Node : "+node.data);
            if (node.left == null && node.right == null) {
                return node.depth;
            }
            if (node.left != null) {
                node.left.depth = 1 + node.depth;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.depth = 1 + node.depth;
                queue.add(node.right);
            }
        }
    }
}
