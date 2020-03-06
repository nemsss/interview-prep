package friends;

import util.TreeNode;

/**
 * Created by cenumah on 2019-12-19
 */
public class LevelOrderTreeSearch {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(3);
        node.left.left = new TreeNode(6);
        node.left.left.left = new TreeNode(12);
        node.left.left.right = new TreeNode(13);
        node.left.right= new TreeNode(8);
        node.left.right.left= new TreeNode(14);
        node.left.right.right= new TreeNode(15);

        node.right = new TreeNode(5);
        node.right.left = new TreeNode(9);
        node.right.left.left = new TreeNode(16);
        node.right.left.right = new TreeNode(17);
        node.right.right= new TreeNode(10);
        node.right.right.left= new TreeNode(18);
        node.right.right.right= new TreeNode(19);

        System.out.println(contains(node, 8));
        System.out.println(contains(node, 16));
        System.out.println(contains(node, 12));
        System.out.println(contains(node, 7));
        System.out.println(contains(node, 1));
    }

    private static boolean contains(TreeNode root, int target) {
        if(root == null) {
            return false;
        }

        int targetLevel = getTargetLevel(root, target);
        int lo = 0;
        int hi = (int) Math.pow(2, targetLevel)-1;


        while(lo <= hi) {
            int mid = (lo+hi)/2;
            int[] path = generatePath(targetLevel, mid);
            TreeNode node = getNode(root, path);

            if(node.data == target){
                return true;
            }
            else if(node.data < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }

        return false;
    }

    private static TreeNode getNode(TreeNode node, int[] path) {
        for(int dir : path) {
            node = dir == 0 ? node.left : node.right;
        }
        return node;
    }

    private static int[] generatePath(int targetLevel, int position) {
        if (targetLevel <= 0) {
            return new int[0];
        }

        int[] path = new int[targetLevel];
        int idx = path.length-1;
        while(idx >= 0) {
            path[idx--] = position % 2;
            position/= 2;
        }

        return path;
    }

    private static int getTargetLevel(TreeNode root, int target) {

        TreeNode node = root;
        int level = -1;
        while(node!= null) {
            level++;
            if(node.data >= target)
                break;
            node = node.right;
        }

        return level;
    }

}
