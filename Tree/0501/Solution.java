class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            int[] res = new int[0];
            return res;
        }
        int maxCount = 0;
        int pre = root.val;
        int preCount = 0;
        int j=0;
        List<Integer> tmp = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                if (pre == p.val) {
                    preCount++;
                } else {
                    if (preCount == maxCount) {
                        tmp.add(pre);
                    } else if (preCount > maxCount) {
                        tmp.clear();
                        maxCount = preCount;
                        tmp.add(pre);
                    } else {
                        ;
                    }
                    pre = p.val;
                    preCount = 1;
                }
                p = p.right;
            }
        }
        if (preCount == maxCount) {
            tmp.add(pre);
        } else if (preCount > maxCount) {
            tmp.clear();
            maxCount = preCount;
            tmp.add(pre);
        } else {
            ;
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}