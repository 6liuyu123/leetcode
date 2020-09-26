class Solution {
    int Sum;    
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public void findPath(int pre, List<Integer> prePath, TreeNode root) {
        pre += root.val;
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < prePath.size(); i++) {
            tmp.add(prePath.get(i));
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (pre == Sum) {
                res.add(tmp);
            }
        }
        if (root.left != null) {
            findPath(pre, tmp, root.left);
        }
        if (root.right != null) {
            findPath(pre, tmp, root.right);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        Sum = sum;
        List<Integer> tmp = new ArrayList<Integer>();
        findPath(0, tmp, root);
        return res;
    }
}