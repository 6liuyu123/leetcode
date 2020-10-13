class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode f=head,s,pre=null;
        while (f != null) {
            s = f.next;
            if (s == null) {
                break;
            }
            f.next = s.next;
            s.next = f;
            if (pre != null) {
                pre.next = s;
            } else {
                head = s;
            }
            pre = f;
            f = f.next;
        }
        return head;
    }
}