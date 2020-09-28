class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        int n;
        Queue<Node> qn = new LinkedList<>();
        qn.add(root);
        Node p;
        while (!qn.isEmpty()) {
            n = qn.size();
            for (int i = 0; i < n-1; i++) {
               p =  qn.poll();
               p.next = qn.peek();
               if (p.left != null) {
                   qn.offer(p.left);
               }
               if (p.right != null) {
                   qn.offer(p.right);
               }
            }
            p = qn.poll();
            p.next = null;
            if (p.left != null) {
                qn.offer(p.left);
            }
            if (p.right != null) {
                qn.offer(p.right);
            }
        }
        return root;
    }
}