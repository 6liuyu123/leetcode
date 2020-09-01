#include<vector>
#include<stack>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    TreeNode* r1;
    TreeNode* r2;
    TreeNode* temp;
    stack<TreeNode*> r1Stack;
    stack<TreeNode*> r2Stack;
    int findNext(bool judge){
        if(judge){
            while(r1!=NULL||!r1Stack.empty()){
                if(r1!=NULL){
                    r1Stack.push(r1);
                    r1=r1->left;
                }else{
                    temp=r1Stack.top();
                    r1Stack.pop();
                    r1=temp->right;
                    break;
                }
            }
        }else{
            while(r2!=NULL||!r2Stack.empty()){
                if(r2!=NULL){
                    r2Stack.push(r2);
                    r2=r2->left;
                }else{
                    temp=r2Stack.top();
                    r2Stack.pop();
                    r2=temp->right;
                    break;
                }
            }
        }
        return temp->val;
    }
    vector<int> getAllElements(TreeNode* root1,TreeNode* root2){
        vector<int> result;
        r1=root1;
        r2=root2;
        bool r1End=false;
        bool r2End=false;
        bool endIn=false;
        int tempVal;
        if(r1==NULL){
            while(!r2Stack.empty()||r2!=NULL){
                result.push_back(findNext(false));
            }
            return result;
        }
        if(r2==NULL){
            while(!r1Stack.empty()||r1!=NULL){
                result.push_back(findNext(true));
            }
            return result;
        }
        int which=0;
        int i1,i2;
        while(which==0||((!r1Stack.empty()||r1!=NULL)&&(!r2Stack.empty()||r2!=NULL))){
            if(which==0||which==-1){
                i1=findNext(true);
                if(r1Stack.empty()&&r1==NULL){
                    r1End=true;
                }
            }
            if(which==0||which==1){
                i2=findNext(false);
                if(r2Stack.empty()&&r2==NULL){
                    r2End=true;
                }
            }
            if(i1>i2){
                which=1;
                result.push_back(i2);
                if(r2End){
                    endIn=true;
                }
            }else{
                which=-1;
                result.push_back(i1);
                if(r1End){
                    endIn=true;
                }
            }
        }
        if(r2End){
            while(!r1Stack.empty()||r1!=NULL){
                if(endIn){
                    result.push_back(i1);
                    r2End=false;
                    endIn=false;
                }
                i1=findNext(true);
                if(r2End&&i2<i1){
                    result.push_back(i2);
                    r2End=false;
                }
                result.push_back(i1);
            }
        }else{
            while(!r2Stack.empty()||r2!=NULL){
                if(endIn){
                    result.push_back(i2);
                    r1End=false;
                    endIn=false;
                }
                i2=findNext(false);
                if(r1End&&i1<i2){
                    result.push_back(i1);
                    r1End=false;
                }
                result.push_back(i2);
            }
        }
        if(r1End){
            result.push_back(i1);
        }
        if(r2End){
            result.push_back(i2);
        }
        return result;
    }
};