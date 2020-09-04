class Solution {

    List<String> res = new ArrayList<>();

    public void bfsTree(TreeNode root, String pre) {
        if (root.left == null && root.right == null) {
            res.add(pre+String.valueOf(root.val));
        }
        if (root.left != null) {
            bfsTree(root.left, pre+String.valueOf(root.val)+"->");
        }
        if (root.right != null) {
            bfsTree(root.right, pre+String.valueOf(root.val)+"->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        bfsTree(root, "");
        return res;
    }
}