#include<string>
#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> diStringMatch(string S){
        int n=S.size();
        char* Ss=new char[n+1];
        vector<int> result(n+1);
        int min=0,max=n;
        strcpy(Ss,S.c_str());
        for(int i=0;i<n;i++){
            if(Ss[i]=='D'){
                result[i]=max;
                max--;
            }else{
                result[i]=min;
                min++;
            }
        }
        if(Ss[n-1]=='D'){
            result[n]=min;
        }else{
            result[n]=max;
        }
        return result;
    }
};