class Solution {
 public ListNode insertionSortList(ListNode head) {
   if (head == null) {
     return head;
   }
   ListNode p = head.next, q, preQ, tmp;
   head.next = null;
   while (p != null) {
     tmp = p.next;
     q = head;
     preQ = null;
     while (q != null && p.val > q.val) {
       preQ = q;
       q = q.next;
     }
     if (q == null) {
       preQ.next = p;
       p.next = null;
     } else if (preQ == null) {
       p.next = head;
       head = p;
     } else {
       preQ.next = p;
       p.next = q;
     }
     p = tmp;
   }
   return head;
 }
}