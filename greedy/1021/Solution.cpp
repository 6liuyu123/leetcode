//采取贪心算法,没用到栈

#include<String>

using namespace std;

class Solution{
    public:
    string removeOuterParentheses(string S) {
        int length=S.size();
        int left=0,right=0;
        char* chrs=new char[length+1];
        for(int i=0,j=0;i<length;i++){
            chrs[i]='\0';
            if(S[i]=='('){
                if(left==0){
                    left++;
                    continue;
                }else{
                    left++;
                    chrs[j]='(';
                    j++;
                }
            }else{
                right++;
                if(right-left==0){
                    left=0;
                    right=0;
                    continue;
                }else{
                    chrs[j]=')';
                    j++;
                }
            }
        }
        return chrs;
    }
};