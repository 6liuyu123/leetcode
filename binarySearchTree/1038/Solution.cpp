#include<vector>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    int sum;
    void backInOrder(TreeNode* root){
        if(root->right!=NULL){
            backInOrder(root->right);
        }
        sum+=root->val;
        root->val=sum;
        if(root->left!=NULL){
            backInOrder(root->left);
        }
    }
    TreeNode* bstToGst(TreeNode* root){
        sum=0;
        if(root==NULL){
            ;
        }else{
            backInOrder(root);
        }
        return root;
    }
};