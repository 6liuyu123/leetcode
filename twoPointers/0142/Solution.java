public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return fast;
    }
}