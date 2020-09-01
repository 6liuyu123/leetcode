#include<string>

using namespace std;

class Solution{
    public:
    int maximum69Number(int num){
        string temp=to_string(num);
        int n=temp.size();
        char* nums=new char[n];
        strcpy(nums,temp.c_str());
        for(int i=0;i<n;i++){
            if(nums[i]=='6'){
                nums[i]='9';
                break;
            }
        }
        int out=nums[0]-'0';
        for(int i=1;i<n;i++){
            out*=10;
            out+=(nums[i]-'0');
        }
        return out;
    }
};