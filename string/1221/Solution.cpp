#include<string>

using namespace std;

class Solution {
public:
    int balancedStringSplit(string s) {
        int length=s.size();
        char* charArray=new char[length+1];
        strcpy(charArray,s.c_str());
        int leftCount=0,rightCount=0,count=0;
        for(int i=0;i<length;i++){
            if(charArray[i]=='L'){
                leftCount++;
            }else if(charArray[i]=='R'){
                rightCount++;
            }else{
                continue;
            }
            if(leftCount==rightCount){
                count++;
                leftCount=0;
                rightCount=0;
            }
        }
        return count;
    }
};