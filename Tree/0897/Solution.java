import java.util.Stack;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        Stack<TreeNode> mid = new Stack<TreeNode>();
        TreeNode mNode = root;
        TreeNode pNode = null;

        while (!mid.isEmpty() || mNode != null) {
            if (mNode != null) {
                mid.push(mNode);
                mNode = mNode.left;
            } else {
                mNode = mid.pop();
                if (pNode == null) {
                    pNode = mNode;
                    root = pNode;
                } else {
                    pNode.left = null;
                    pNode.right = mNode;
                    pNode = pNode.right;
                }
                mNode = mNode.right;
            }
        }

        pNode.left = null;

        return root;

    }
}