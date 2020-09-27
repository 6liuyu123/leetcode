/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if ((root.val-p.val)*(root.val-q.val) <= 0) {
            return root;
        }
        if (root.right == null && root.left == null) {
            return null;
        }
        TreeNode r = null, l = null;
        if (root.left != null) {
            l = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            r = lowestCommonAncestor(root.right, p, q);
        }
        if (r == null) {
            return l;
        } else {
            return r;
        }
    }
}