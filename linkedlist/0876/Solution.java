class Solution{
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public ListNode middleNode(ListNode head){
        boolean judge=true;
        ListNode p=head;
        ListNode mid=head;
        while(p!=null){
            p=p.next;
            if(judge==true){
                judge=false;
            }else{
                judge=true;
                mid=mid.next;
            }
        }
        return mid;
    }
}