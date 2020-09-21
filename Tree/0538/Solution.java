class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        int preSum = 0;
        Stack<TreeNode> S = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !S.isEmpty()) {
            while (p != null) {
                S.push(p);
                p = p.right;
            }
            p = S.pop();
            p.val += preSum;
            preSum = p.val;
            p = p.left;
        }
        return root;
    }
}