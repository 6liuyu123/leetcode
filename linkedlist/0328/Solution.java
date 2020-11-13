class Solution {
 public ListNode oddEvenList(ListNode head) {
     int  i = 0;
     ListNode p = head, oddP = null, evenP = null, nextP = null;
     if (head == null) {
         return head;
     }
     while (p != null) {
         if (i % 2 == 0) {
             if (evenP == null) {
                 evenP = p;
             } else {
                 evenP.next = p;
                 evenP = evenP.next;
             }
             p = p.next;
             evenP.next = null;
         } else {
             if (oddP == null) {
                 oddP = p;
                 nextP = oddP;
             } else {
                 oddP.next = p;
                 oddP = oddP.next;
             }
             p = p.next;
             oddP.next = null;
         }
         i++;
     }
     evenP.next = nextP;
     return head;
 }
}