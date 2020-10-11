class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode lN = invertTree(root.left);
            TreeNode rN = invertTree(root.right);
            root.left = rN;
            root.right = lN;
        }
        return root;
    }
}