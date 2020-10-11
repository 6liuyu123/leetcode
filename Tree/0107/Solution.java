import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<>>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < q.size(); i++) {
                temp = q.poll();
                tmp.add(temp);
                if (temp.left != null) {
                    tmp.add(temp.left);
                }
                if (temp.right != null) {
                    tmp.add(temp.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}