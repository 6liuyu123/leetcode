class Solution{

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head,int n){
        int i=0;
        ListNode p=head,q=head,preq=head;
        for(;i<n;i++){
            p=p.next;
        }
        if(p==null){
            return head.next;
        }
        while(p!=null){
            p=p.next;
            preq=q;
            q=q.next;
        }
        preq.next=q.next;
        return head;
    }
}