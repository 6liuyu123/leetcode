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
    vector<TreeNode*> allPossibleFBT(int N){
        vector<vector<TreeNode*> > results(N/2+1);
        if(N%2==0){
            return results[0];
        }
        TreeNode* tempRoot;
        tempRoot=new TreeNode(0);
        results[0].push_back(tempRoot);
        for(int i=3;i<=N;i+=2){
            for(int j=1;j<i;j+=2){
                for(int l=0;l<results[j/2].size();l++){
                    for(int r=0;r<results[(i-1-j)/2].size();r++){
                        tempRoot=new TreeNode(0);
                        tempRoot->left=results[j/2][l];
                        tempRoot->right=results[(i-1-j)/2][r];
                        results[i/2].push_back(tempRoot);
                    }
                }
            }
        }
        return results[N/2];
    }
};