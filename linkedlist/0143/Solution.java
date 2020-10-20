class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        int n = 0, i;
        ListNode p = head, fhead, t, t1;
        while (p != null) {
            p = p.next;
            n++;
        }
        if (n <= 2) {
            return;
        }
        p = head;
        for (i = 1; i < n/2; i++) {
            p = p.next;
        }
        if ((n%2) == 1) {
            p = p.next;
        }
        t = p.next;
        p.next = null;
        p = t;
        fhead = p;
        p = p.next;
        fhead.next = null;
        while (p != null) {
            t = p.next;
            p.next = fhead;
            fhead = p;
            p = t;
        }
        t = head;
        t1 = fhead;
        for (i = 1; i <= n; i++) {
            if (i == 1) {
                p = head;
                t = t.next;
            } else {
                if (i%2 == 1) {
                    p.next = t;
                    t = t.next;
                    p = p.next;
                } else {
                    p.next = t1;
                    t1 = t1.next;
                    p = p.next;
                }
            }
        }
        
    }
}