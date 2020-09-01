#include<iostream>
#include<unordered_set>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class FindElements{
    private:
    unordered_set<int> leafNum;
    public:
    void create(int rootVal,TreeNode* root){
        root->val=rootVal;
        leafNum.insert(rootVal);
        if(root->left!=NULL){
            create(rootVal*2+1,root->left);
        }
        if(root->right!=NULL){
            create(rootVal*2+2,root->right);
        }
    }
    FindElements(TreeNode* root){
        root->val=0;
        leafNum.insert(0);
        if(root->left!=NULL){
            create(1,root->left);
        }
        if(root->right!=NULL){
            create(2,root->right);
        }
    }
    bool find(int target){
        if(leafNum.find(target)!=leafNum.end()){
            return true;
        }else{
            return false;
        }
    }
};