#include<iostream>
#include<queue>

using namespace std;

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    int sumEvenGrandparent(TreeNode* root){
        if(root==NULL){
            return 0;
        }
        int count=0;
        TreeNode* temp=root;
        queue<TreeNode*> qt;
        qt.push(temp);
        while(!qt.empty()){
            temp=qt.front();
            qt.pop();
            if(temp->val%2==0){
                if(temp->left!=NULL){
                    if(temp->left->left!=NULL){
                        count+=temp->left->left->val;
                    }
                    if(temp->left->right!=NULL){
                        count+=temp->left->right->val;
                    }
                }
                if(temp->right!=NULL){
                    if(temp->right->left!=NULL){
                        count+=temp->right->left->val;
                    }
                    if(temp->right->right!=NULL){
                        count+=temp->right->right->val;
                    }
                }
            }
            if(temp->left!=NULL){
                qt.push(temp->left);
            }
            if(temp->right!=NULL){
                qt.push(temp->right);
            }
        }
        return count;
    }
};