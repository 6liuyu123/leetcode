class Solution {
    public int getMinimumDifference(TreeNode root) {
        int pre = -1;
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while (p!=null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            if (pre == -1) {
                pre = p.val;
            } else {
                if ((p.val-pre) < min) {
                    min = p.val-pre;
                }
                pre = p.val;
            }
            p = p.right;
        }
        return min;
    }
}