#include<iostream>

using namespace std;

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode * right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    TreeNode* searchBST(TreeNode* root,int val){
        if(root==NULL){
            return NULL;
        }
        TreeNode* temp=root;
        while(temp!=NULL){
            if(temp->val>val){
                temp=temp->left;
            }else if(temp->val==val){
                return temp;
            }else{
                temp=temp->right;
            }
        }
        return NULL;
    }
};