#include<String>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};

class Solution{
    public:
    int aheadChr;
    int p=-1;
    int n;
    int result;
    bool end=false;
    string t;

    TreeNode* createNode(int level){
        aheadChr=0;
        p++;
        while(t[p]=='-'&&p<n){
            aheadChr++;
            p++;
        }
        if(aheadChr==level){
            result=t[p]-'0';
            p++;
            while(t[p]!='-'&&p<n){
                result*=10;
                result+=(t[p]-'0');
                p++;
            }
            if(t[p]=='-'){
                p--;
            }else{
                end=true;
            }
            TreeNode* root=new TreeNode(result);
            if(end){
                ;
            }else{
                root->left=createNode(level+1);
                if(end){
                    ;
                }else{
                    if(aheadChr==level+1){
                        p-=aheadChr+1;
                        root->right=createNode(level+1);
                    }
                }
            }
            return root;
        }else{
            return NULL;
        }
    }

    TreeNode* recoverFromPreorder(string S){
        n=S.size();
        t=S;
        return createNode(0);
    }
};