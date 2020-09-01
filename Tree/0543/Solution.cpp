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
    int max=0;
    int findDepth(TreeNode* root,int level){
        if(root->left!=NULL&&root->right!=NULL){
            int leftDepth=findDepth(root->left,level+1);
            int rightDepth=findDepth(root->right,level+1);
            if(rightDepth+leftDepth-2*level>max){
                max=rightDepth+leftDepth-2*level;
            }
            return leftDepth>rightDepth?leftDepth:rightDepth;
        }else if(root->left!=NULL&&root->right==NULL){
            return findDepth(root->left,level+1);
        }else if(root->left==NULL&&root->right!=NULL){
            return findDepth(root->right,level+1);
        }else{
            return level;
        }
    }

    int diameterOfBinaryTree(TreeNode* root){
        if(root==NULL){
            return 0;
        }
        if(root->left!=NULL&&root->right!=NULL){
            int leftDepth=findDepth(root->left,1);
            int rightDepth=findDepth(root->right,1);
            if(rightDepth+leftDepth>max){
                max=rightDepth+leftDepth;
            }
            return max;
        }else if(root->left!=NULL&&root->right==NULL){
            int leftDepth=findDepth(root->left,1);
            if(leftDepth>max){
                max=leftDepth;
            }
            return max;
        }else if(root->left==NULL&&root->right!=NULL){
            int rightDepth=findDepth(root->right,1);
            if(rightDepth>max){
                max=rightDepth;
            }
            return max;
        }else{
            return 0;
        }
    }
};