#include<string>

using namespace std;

class Solution{
    public:
    bool judgeCircle(string moves){
        int n=moves.size();
        int u=0,r=0;
        char* move=new char[n+1];
        strcpy(move,moves.c_str());
        for(int i=0;i<n;i++){
            if(move[i]=='U'){
                u++;
            }else if(move[i]=='D'){
                u--;
            }else if(move[i]=='R'){
                r++;
            }else{
                r--;
            }
        }
        if(u==0&&r==0){
            return true;
        }else{
            return false;
        }
    }
};