#include<String>
#include<vector>
#include<unordered_set>

using namespace std;

class Solution{
    public:
    int minDeletionSize(vector<string>& A){
        if(A.empty()){
            return 0;
        }
        int m=A[0].size();
        int i;
        char* last=new char[m+1];
        char* now=new char[m+1];
        strcpy(last,A[0].c_str());
        vector<string>::iterator end=A.end();
        unordered_set<int> decrease;
        for(vector<string>::iterator it=++A.begin();it!=end;it++){
            strcpy(now,(*it).c_str());
            for(i=0;i<m;i++){
                if(now[i]<last[i]){
                    decrease.insert(i);
                }
                if(decrease.size()==m){
                    return m;
                }
                last[i]=now[i];
                now[i]='\0';
            }            
        }
        return decrease.size();
    }
};