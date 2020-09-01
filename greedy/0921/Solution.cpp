#include<String>

using namespace std;

class Solution{
    public:
    int minAddToMakeValid(string S) {
        int leftWaitMatch=0;
        int rightWaitMatch=0;
        for(int i=0;i<S.size();i++){
            if(S[i]=='('){
                leftWaitMatch++;
            }else{
                if(leftWaitMatch){
                    leftWaitMatch--;
                }else{
                    rightWaitMatch++;
                }
            }
        }
        return leftWaitMatch+rightWaitMatch;
    }
};