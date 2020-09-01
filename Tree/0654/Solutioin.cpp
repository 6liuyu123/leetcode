#include<vector>
#include<algorithm>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    TreeNode* constructMaximumBinaryTree(vector<int>& nums){
        if(nums.empty()){
            return NULL;
        }
        vector<int>::iterator end=nums.end();
        TreeNode* root=new TreeNode(nums[0]);
        TreeNode* temp;
        TreeNode* newNode;
        for(vector<int>::iterator p=++nums.begin();p!=end;p++){
            newNode=new TreeNode(*p);
            if(root->val<newNode->val){
                newNode->left=root;
                root=newNode;
            }else{
                temp=root;
                while(temp->right!=NULL){
                    if(temp->right->val<newNode->val){
                        newNode->left=temp->right;
                        temp->right=newNode;
                        break;
                    }
                    temp=temp->right;
                }
                if(temp->right==NULL){
                    temp->right=newNode;
                }
            }
        }
        return root;
    }
};