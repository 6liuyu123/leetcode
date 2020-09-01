class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private int judge(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = judge(root.left) + 1;
        }
        if (root.right != null) {
            right = judge(root.right) + 1;
        }
        if (left - right > 1 || right - left > 1 || left < 0 || right < 0) {
            return -2;
        } else {
            return left > right ? left : right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return judge(root) < 0 ? false : true;
        }
    }    
}