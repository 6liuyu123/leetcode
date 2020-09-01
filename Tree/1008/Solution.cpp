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
    TreeNode* bstFromPreorder(vector<int>& preorder){
        if(preorder.empty()){
            return NULL;
        }
        vector<int>::iterator end=preorder.end();
        TreeNode* root=new TreeNode(preorder[0]);
        TreeNode* parent;
        TreeNode* newNode;
        for(vector<int>::iterator p=++preorder.begin();p!=end;p++){
            parent=root;
            newNode=new TreeNode(*p);
            while(true){
                if(parent->val>(*p)){
                    if(parent->left!=NULL){
                        parent=parent->left;
                    }else{
                        parent->left=newNode;
                        break;
                    }
                }else{
                    if(parent->right!=NULL){
                        parent=parent->right;
                    }else{
                        parent->right=newNode;
                        break;
                    }
                }
            }
        }
        return root;
    }
};