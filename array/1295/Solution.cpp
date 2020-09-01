#include<vector>

using namespace std;

class Solution {
public:
    bool judge(int num){
        int n=0;
        while(num!=0){
            num/=10;
            n++;
        }
        return (n%2==0);
    }
    int findNumbers(vector<int>& nums) {
        int n=0;
        for(vector<int>::iterator it=nums.begin();it!=nums.end();it++){
            if(judge(*it)){
                n++;
            }
        }
        return n;
    }
};