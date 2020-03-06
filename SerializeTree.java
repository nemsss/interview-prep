package educative.trees;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by cenumah on 2019-12-23
 */
public class SerializeTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right= new TreeNode(8);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right= new TreeNode(10);

        String values = serialize(root);
        TreeNode root2 = deserialize(values);

        System.out.println(isEqual(root, root2));
    }

    private static String serialize(TreeNode root) {
        if(root == null)
            return "N ";

        return root.data + " " + serialize(root.left) + serialize(root.right);
    }

    private static TreeNode deserialize(String values) {
        String[] arr = values.split(" ");
        LinkedList<String> data = Arrays.stream(arr).collect(Collectors.toCollection(LinkedList::new));
        return deserialize(data);
    }

    private static TreeNode deserialize(LinkedList<String> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        if("N".equals(values.peek())){
            values.poll();
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values.poll()));
        root.left = deserialize(values);
        root.right = deserialize(values);
        return root;

    }

    private static boolean isEqual(TreeNode r1, TreeNode r2) {
        if(r1 == r2) {
            return true;
        }

        if(r1 == null || r2 == null) {
            return false;
        }

        return r1.data == r2.data && isEqual(r1.left, r2.left) && isEqual(r1.right, r2.right);
    }
}
