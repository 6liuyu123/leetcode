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
    TreeNode* prune(TreeNode* root){
        if(root->left!=NULL){
            root->left=prune(root->left);
        }
        if(root->right!=NULL){
            root->right=prune(root->right);
        }
        if(root->left==NULL&&root->right==NULL&&root->val==0){
            return NULL;
        }else{
            return root;
        }
    }
    TreeNode* pruneTree(TreeNode* root){
        if(root==NULL){
            return NULL;
        }
        root=prune(root);
        return root;
    }
};