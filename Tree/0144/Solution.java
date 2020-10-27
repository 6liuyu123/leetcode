class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        while (!s.isEmpty() || t != null) {
            if (t != null) {
                res.add(t.val);
                TreeNode tmp = t;
                s.push(tmp);
                t = t.left;
            } else {
                TreeNode tmp = s.pop();
                t = tmp.right;
            }
        }
        return res;
    }
}