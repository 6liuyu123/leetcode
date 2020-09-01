#include<iostream>
#include"Node.cpp"

using namespace std;

class Solution{
    public:
    vector<int> result;
    void pre(Node* root){
        result.push_back(root->val);
        if(!root->children.empty()){
            vector<Node*>::iterator end=root->children.end();
            for(vector<Node*>::iterator it=root->children.begin();it!=end;it++){
                pre(*it);
            }
        }
    }
    vector<int> preorder(Node* root){
        if(root==NULL){
            ;
        }else{
            pre(root);
        }
        return result;
    }
};