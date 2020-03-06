package friends;

import util.TreeNode;

import java.util.*;

/**
 * Created by cenumah on 2019-12-18
 */
public class ZigZagTreeTraversal {
}

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<List<Integer>> getZigZagTraversal(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean goRight = true;

        while(!q.isEmpty()) {
            int size = q.size();

            addLevelToResultList(q,result, goRight);
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            // done with level
        }

        return result;
    }

    // offer and poll()
    // ListIterator iterator = this.visitedUrls.listIterator(this.visitedUrls.size());
    // while (iterator.hasPrevious()) {
    //  System.out.println(iterator.previous());
    // }

    private static void addLevelToResultList(Queue<TreeNode> q, List<List<Integer>> res, boolean goRight) {

        List<Integer> level = new ArrayList<>();

        for(TreeNode node : q) {
            level.add(node.data);
        }

        if(!goRight) {
            Collections.reverse(level);
        }

        res.add(level);
    }
}

