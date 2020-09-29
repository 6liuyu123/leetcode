class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p, lastVisit;
        p = root;
        lastVisit = null;
        while (p != null) {
            s.push(p);
            p = p.left;
        }
        while (!s.isEmpty()) {
            p = s.pop();
            if (p.right == null || p.right == lastVisit) {
                res.add(p.val);
                lastVisit = p;
            } else {
                s.push(p);
                p = p.right;
                while (p != null) {
                    s.push(p);
                    p = p.left;
                }
            }
        }
        return res;
    }
}