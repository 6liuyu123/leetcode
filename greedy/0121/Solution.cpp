#include<vector>

using namespace std;

class Solution{
    public:
    int maxProfit(vector<int>& prices){
        int n=prices.size();
        if(n==0){
            return 0;
        }
        int min=prices[0];
        int result=0;
        for(int i=1;i<n;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            if(prices[i]-min>result){
                result=prices[i]-min;
            }
        }
        return result;
    }
};