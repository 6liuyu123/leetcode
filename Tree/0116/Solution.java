class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        Node p, pre = root;
        int i, n;
        while (!q.isEmpty()) {
            n = q.size();
            for (i = 0; i < n; i++) {
                p = q.poll();
                if (i != 0) {
                    pre.next = p;
                }
                pre = p;
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
        }
        return root;
    }
}