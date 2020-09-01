#include<iostream>

using namespace std;

struct ListNode{
    int val;
    ListNode* next;
    ListNode(int x):val(x),next(NULL){}
};

class Solution{
    public:
    ListNode* reverseList(ListNode* head){
        ListNode* myhead=NULL;          //新链表的头节点
        ListNode* p=head;               //工作节点
        ListNode* temp;                 //临时存储节点
        while(p!=NULL){
            temp=p->next;               //临时存储节点存放p的下一个节点
            p->next=myhead;             //当前工作节点的后一个节点设为原新链表头
            myhead=p;                   //新链表的头节点设为工作节点
            p=temp;                     //工作节点后移
        }
        return myhead;
    }
};