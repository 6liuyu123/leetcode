#include<iostream>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    TreeNode* insertIntoBST(TreeNode* root,int val){
        if(root==NULL){
            return new TreeNode(val);
        }
        TreeNode* p=root;
        while(true){
            if(val<p->val){
                if(p->left==NULL){
                    TreeNode* newNode=new TreeNode(val);
                    p->left=newNode;
                    break;
                }else{
                    p=p->left;
                }
            }else if(val==p->val){
                break;
            }else{
                if(p->right==NULL){
                    TreeNode* newNode=new TreeNode(val);
                    p->right=newNode;
                    break;
                }else{
                p=p->right;
                }
            }
        }
        return root;
    }
};