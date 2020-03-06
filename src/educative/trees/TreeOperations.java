package educative.trees;

import util.TreeNode;

import java.util.*;

/**
 * Created by cenumah on 2019-12-23
 */
public class TreeOperations {

    public static void main(String[] args) {

        TreeNode root = insert(null, 7);
        root = insert(root, 5);
        root = insert(root, 9);
        root = insert(root, 10);
        root = insert(root, 8);
        root = insert(root, 6);
        root = insert(root, 3);

        System.out.println(findKthMaximum(root, 1));
        System.out.println(findKthMaximum(root, 3));
        System.out.println(findKthMaximum(root, 7));
        System.out.println("-------------------");

        System.out.println(inOrderSuccessor(root, 6));
        System.out.println(inOrderSuccessor(root, 7));
        System.out.println(inOrderSuccessor(root, 8));

        System.out.println(root.left.right != null);
        root = delete(root, 7);
        System.out.println(root.data == 6);
        System.out.println(root.left.right == null);

        root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(-3);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(10);

        root = deleteZeroSumSubTrees(root, new HashMap<>());
        System.out.println(root.left == null);
        System.out.println(root.right.left == null);
    }

    private static TreeNode insert(TreeNode root, int data) {

        if(root == null) {
            return new TreeNode(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        }
        else if(data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    private static TreeNode delete(TreeNode root, int target) {

        if(root == null) {
            return root;
        }

        if(root.data > target) {
            root.left = delete(root.left, target);
        }
        else if(root.data < target) {
            root.right = delete(root.right, target);
        }
        else {
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            TreeNode successor = getMaxMinValue(root.left);
            successor.left = delete(root.left, successor.data);
            successor.right = root.right;
            root = successor;
        }

        return root;
    }

    private static TreeNode getMaxMinValue(TreeNode node) {

        if(node == null) {
            return null;
        }

        while(node.right != null) {
            node = node.right;
        }

        return node;
    }

    private static TreeNode findKthMaximum(TreeNode root, int k) {
        return findKthMaximum(root, new int[]{0}, k);
    }

    private static TreeNode findKthMaximum(TreeNode root, int[] current, int k) {
        if(root == null)
            return root;

        TreeNode res = findKthMaximum(root.right, current, k);
        if(res != null){
            return res;
        }

        current[0]+= 1;
        if(current[0] == k) {
            return root;
        }

        return findKthMaximum(root.left, current, k);
    }

    private static TreeNode deleteZeroSumSubTrees(TreeNode root, Map<TreeNode, Integer> sums) {
        if(root == null) {
            return root;
        }


        root.left = deleteZeroSumSubTrees(root.left, sums);
        root.right = deleteZeroSumSubTrees(root.right, sums);

        int sum =  root.data + getSum(root.left, sums) + getSum(root.right, sums);
        return sum == 0 ? null : root;
    }

    private static int getSum(TreeNode node, Map<TreeNode, Integer> sums) {
        if(node == null) {
            return 0;
        }

        if(sums.containsKey(node)) {
            return sums.get(node);
        }

        int sum = node.data + (node.left == null ? 0 : sums.get(node.left)) + (node.right == null ? 0 : sums.get(node.right));

        sums.put(node, sum);
        return sum;
    }

    private static TreeNode inOrderSuccessor(TreeNode root, int target) {

        if(root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode max = root;
        while(max!= null || !stack.isEmpty()) {
            if(max != null) {
                if(max.left != null && max.left.data == target) {
                    return max;
                }
                stack.push(max);
                max = max.left;
                continue;
            }

            max = stack.pop();
            if(max.data > target) {
                return max;
            }
            max = max.left;
        }

        return max;
    }
}
