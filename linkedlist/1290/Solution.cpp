#include<iostream>

using namespace std;

struct ListNode{
    int val;
    ListNode *next;
    ListNode(int x):val(x),next(NULL){}
};

class Solution{
    public:
    int getDecimalValue(ListNode* head){
        int n=head->val;
        ListNode* temp=head;
        while(temp->next!=NULL){
            n=n*2+temp->next->val;
            temp=temp->next;
        }
        return n;
    }
};