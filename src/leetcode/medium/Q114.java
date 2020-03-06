package leetcode.medium;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by cenumah on 2020-01-20
 */
public class Q114 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right= new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right= new TreeNode(6);

        System.out.println(root);
    }

    public void flatten(TreeNode root) {

        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root!= null) {
            if(stack.isEmpty()) {
                while(root!= null) {
                    stack.push(root);
                    root = root.left;
                }
            }

            root = stack.pop();
            if(prev != null) {
                prev.right = root;
            }
            prev = root;
            root = root.right;
        }
    }
}
