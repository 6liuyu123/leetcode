class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sumOfLeftLeaves(root.right);
        }
        return res;
    }
}