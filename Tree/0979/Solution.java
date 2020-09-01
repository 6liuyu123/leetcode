class Solution {

    int res = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = dfs(node.left);
        int R = dfs(node.right);
        res += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    
}