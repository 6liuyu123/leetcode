#include<vector>
#include<string>

using namespace std;

class Solution{
    public:
    vector<int> partitionLabels(string S){
        int length=S.size();
        char tempChr='A';
        int i,j,begin=0,last=0;
        vector<int> result;
        for(i=0;i<length;i++){
            for(j=length-1;j>=last;j--){
                if(S[i]==S[j]){
                    break;
                }
            }
            if(j>last){
                last=j;
            }
            if(last==i){
                result.push_back(j-begin+1);
                begin=i+1;
            }          
        }
        return result;
    }
};