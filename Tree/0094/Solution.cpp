class Solution{
public:
    vector<int> inorderTraversal(TreeNode* root){
        TreeNode* temp;
        stack<TreeNode*> sTree;
        vector<int> vTree;
        temp=root;
        while(!sTree.empty()||temp!=NULL){
            if(temp==NULL){
                temp=sTree.top();
                vTree.push_back(temp->val);
                temp=temp->right;
                sTree.pop();
            }else{
                sTree.push(temp);
                temp=temp->left;
            }
        }
        return vTree;
    }
};