#include<queue>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    int maxLevelSum(TreeNode* root){
        if(root==NULL){
            return 0;
        }
        int levelSum=root->val;
        int level=0;
        int MinLevel=0;
        int Max=INT_MIN;
        bool hasFirst=true;
        TreeNode* p;
        TreeNode* first;
        queue<TreeNode*> qT;
        first=root;
        qT.push(root);
        while(!qT.empty()){
            p=qT.front();
            qT.pop();
            if(p==first){
                hasFirst=false;
                if(levelSum>Max){
                    Max=levelSum;
                    MinLevel=level;
                }
                levelSum=p->val;
                level++;
            }else{
                levelSum+=p->val;
            }
            if(p->left!=NULL){
                if(!hasFirst){
                    hasFirst=true;
                    first=p->left;
                }
                qT.push(p->left);
            }
            if(p->right!=NULL){
                if(!hasFirst){
                    hasFirst=true;
                    first=p->right;
                }
                qT.push(p->right);
            }
        }
        return Max>levelSum?MinLevel:level;
    }
};