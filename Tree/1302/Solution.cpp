//采用层序遍历，一次遍历一层，并记录该层的sum，如果这层元素有孩子说明这层不是最后一层

#include<iostream>
#include<queue>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){};
};

class Solution{
    public:
    int deepestLeavesSum(TreeNode* root){
        if(root==NULL){
            return 0;
        }
        int tempSum;
        TreeNode* p=root;        //工作指针
        TreeNode* tempHead=root;         //每一层的第一个节点
        TreeNode* temp;
        queue<TreeNode*> qt;
        qt.push(p);
        while(!qt.empty()){
            temp=qt.front();
            if(temp==tempHead){
                tempHead=NULL;
                tempSum=temp->val;
            }else{
                tempSum+=temp->val;
            }
            if(temp->left!=NULL){
                if(tempHead==NULL){
                    tempHead=temp->left;
                }
                qt.push(temp->left);
            }
            if(temp->right!=NULL){
                if(tempHead==NULL){
                    tempHead=temp->right;
                }
                qt.push(temp->right);
            }
            qt.pop();
        }
        return tempSum;
    }
};