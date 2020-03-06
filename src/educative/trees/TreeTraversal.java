package educative.trees;

import util.TreeNode;

import java.time.Instant;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by cenumah on 2019-12-23
 */
public class TreeTraversal {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(3);
        node.left.left = new TreeNode(6);
        node.left.right= new TreeNode(8);
        node.left.left.left = new TreeNode(12);
        node.left.left.right = new TreeNode(13);
        node.left.right.left= new TreeNode(14);
        node.left.right.right= new TreeNode(15);

        node.right = new TreeNode(5);
        node.right.left = new TreeNode(9);
        node.right.right= new TreeNode(10);
        node.right.left.left = new TreeNode(16);
        node.right.left.right = new TreeNode(17);
        node.right.right.left= new TreeNode(18);
        node.right.right.right= new TreeNode(19);

        System.out.println(Instant.now());
        inOrderIterative(node);
        System.out.println(Instant.now());
        inOrderRecursive(node);
        System.out.println(Instant.now());

        System.out.println("---------------------");

        System.out.println(Instant.now());
        preOrderIterative(node);
        System.out.println(Instant.now());
        preOrderRecursive(node);
        System.out.println(Instant.now());
    }

    private static void inOrderIterative(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.add(root);
                root = root.left;
                continue;
            }

            root = stack.pop();
            System.out.print(root.data+" ");
            root = root.right;
        }
    }

    private static void inOrderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrderRecursive(root.left);
        System.out.print(root.data+" ");
        inOrderRecursive(root.right);
    }

    private static void postOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    private static void preOrderIterative(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.data+" ");

            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private static void preOrderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
}
