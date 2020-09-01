import java.util.Stack;

class Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }    
    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Stack<Integer> l1Stack=new Stack<Integer>();
        Stack<Integer> l2Stack=new Stack<Integer>();
        ListNode p=l1;
        while(p!=null){
            l1Stack.push(p.val);
            p=p.next;
        }
        p=l2;
        while(p!=null){
            l2Stack.push(p.val);
            p=p.next;
        }
        int temp1,temp2,temp=0;
        ListNode head=null;
        while(!l1Stack.empty()||!l2Stack.empty()){
            if(!l1Stack.empty()){
                temp1=l1Stack.pop();
            }else{
                temp1=0;
            }
            if(!l2Stack.empty()){
                temp2=l2Stack.pop();
            }else{
                temp2=0;
            }
            ListNode newNode=new ListNode((temp1+temp2+temp)%10);
            newNode.next=head;
            head=newNode;
            temp=(temp1+temp2+temp)/10;
        }
        if(temp!=0){
            ListNode newNode=new ListNode(1);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }
    
}