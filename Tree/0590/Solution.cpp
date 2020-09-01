#include<vector>
#include<stack>
#include"Node.cpp"

using namespace std;

class Solution{
    public:
    vector<int> result;
    void visit(Node* root){
        result.push_back(root->val);
    }
    void post(Node* root){
        if(!root->children.empty()){
            vector<Node*>::iterator end=root->children.end();
            for(vector<Node*>::iterator it=root->children.begin();it!=end;it++){
                post(*it);
            }
        }
        visit(root);
    }
    vector<int> postorder(Node* root){
        if(root==NULL){
            ;
        }else{
            post(root);
        }
        return result;
    }
};