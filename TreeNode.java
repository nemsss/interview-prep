package util;

/**
 * Created by cenumah on 2019-12-17
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int data){
        this.data = data;
    }

    public TreeNode() {

    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
