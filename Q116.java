package leetcode.medium;

import util.Node;
import util.TreeNode;

import java.util.Arrays;

/**
 * Created by cenumah on 2020-01-25
 */
public class Q116 {

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right= new Node(7);

        System.out.println(new Q116().connect(root));
    }

    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null) { // update left next
            if (root.right != null)
                root.left.next = root.right; // if right child exists - simple connect left.next to right
            else
                root.left.next = findNext(root); // if not - scan parent next node until we find the first left or right child
        }
        if (root.right != null) { // update right next
            root.right.next = findNext(root);
        }

        connect(root.right); // update the right nodes first
        connect(root.left);
        return root;
    }

    private Node findNext(Node root) { // get parent node
        while (root.next != null) { // scan all next parent nodes until we find the first left or right child
            root = root.next;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
        }
        return null;
    }

    public TreeNode connectA(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode firstOnLevel = root;
        while (firstOnLevel.left != null) {

            TreeNode parent = firstOnLevel;
            while (parent != null) {
                //Connect left child to right child
                parent.left.next = parent.right;
                //Connect right child to cousin via your own sibling
                parent.right.next = parent.next == null ? null : parent.next.left;

                parent = parent.next;
            }

            firstOnLevel = firstOnLevel.left;
        }

        return root;
    }

    public TreeNode connect1(TreeNode root) {

        if(root == null) {
            return root;
        }

        int height = height(root);
        int nodes = (int) Math.pow(2, height+1) -1;
        int level = 1; int max = 1;
        for(int i=1; i<=nodes; i++) {
            TreeNode node = get(root, i, level);
            if(i == max) {
                level++;
                max = ((int) Math.pow(2, level)) - 1;
            } else {
                node.next = get(root, i+1, level);
            }
        }

        return root;
    }

    private TreeNode get(TreeNode root, int idx, int level) {
        if(idx == 1) {
            return root;
        }

        int[] path = new int[level-1];
        int i = 0;
        int copy = idx;
        while (i < path.length) {
            path[i++] = copy % 2;
            copy/= 2;
        }

        TreeNode node = root;
        i = level-2;
        while (i>= 0) {
            node = path[i] == 0 ? node.left : node.right;
            i--;
        }

        return node;
    }

    private int height (TreeNode root) {
        if(root == null) {
            return -1;
        }

        return 1+ Math.max(height(root.left), height(root.right));
    }
}
