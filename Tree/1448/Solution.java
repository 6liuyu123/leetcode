class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int result = 0;

    private void findBigger(TreeNode root, int tempMax) {
        if (root.right != null) {
            if (root.right.val < tempMax) {
                findBigger(root.right, tempMax);
            } else {
                result++;
                findBigger(root.right, root.right.val);
            }
        }
        if (root.left != null) {
            if (root.left.val < tempMax) {
                findBigger(root.left, tempMax);
            } else {
                result++;
                findBigger(root.left, root.left.val);
            }
        }
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return result;
        }
        result++;
        findBigger(root, root.val);
        return result;
    }
}