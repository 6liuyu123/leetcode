class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[n-1]);
        int i;
        for (i = 0; i < n; i++) {
            if (inorder[i] == postorder[n-1]) {
                break;
            }
        }
        int l = i, r = i+1;
        if (i == 0) {
            root.left = null;
        } else {
            int[] linorder = new int[l];
            int[] lpoorder = new int[l];
            for (int j = 0; j < l; j++) {
                linorder[j] = inorder[j];
                lpoorder[j] = postorder[j];
            }
            root.left = buildTree(linorder, lpoorder);

        }
        if ((n-i-1) == 0) {
            root.right = null;
        } else {
            int[] rinorder = new int[n-i-1];
            int[] rpoorder = new int[n-i-1];
            for (int j = 0; j < n-i-1; j++) {
                rinorder[j] = inorder[i+j+1];
                rpoorder[j] = postorder[i+j];
            }
            root.right = buildTree(rinorder, rpoorder);

        }
        return root;
    }
}