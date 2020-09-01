#include<vector>

using namespace std;

class Solution{
    public:
    bool validateBinaryTreeNodes(int n,vector<int>& leftChild,vector<int>& rightChild){
        bool* judge=new bool[n];
        int i,j=0;
        for(i=0;i<n;i++){
            judge[i]=true;
        }
        for(i=0;i<n;i++){
            if(leftChild[i]==-1){
                ;
            }else{
                if(judge[leftChild[i]]){
                    judge[leftChild[i]]=false;
                }else{
                    return false;
                }
            }
            if(rightChild[i]==-1){
                ;
            }else{
                if(judge[rightChild[i]]){
                    judge[rightChild[i]]=false;
                }else{
                    return false;
                }
            }
        }
        for(i=0;i<n;i++){
            if(judge[i]){
                j++;
            }
        }
        return j==1?true:false;
    }
};