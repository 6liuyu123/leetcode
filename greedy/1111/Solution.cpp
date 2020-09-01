#include<string>
#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> maxDepthAfterSplit(string seq){
        int n=seq.length();
        vector<int> result(n);
        result[0]=0;
        for(int i=1;i<n;i++){
            if(seq[i]==seq[i-1]){
                result[i]=1-result[i-1];
            }else{
                result[i]=result[i-1];
            }
        }
        return result;
    }
};