#include<String>
#include<vector>

using namespace std;

class Solution{
    public:
    int coinChange(vector<int>& coins,int amount){
        int coinSize=coins.size();          //有多少种硬币
        sort(coins.begin(),coins.end());    //硬币按照大小排序，后面提高效率
        if(amount%coins[coinSize-1]==0){    //如果可以贪心直接贪心
            return amount/coins[coinSize-1];
        }
        if(coins[0]>amount){
            return -1;                      //最小的硬币比需要的数大，直接返回
        }
        int* amounts=new int[amount+1];     //amounts数组的意义是，amounts[i],amount==i时，最少的硬币组合是多少种
        for(int i=0,j=0;i<=amount;i++){
            if(j<coinSize&&i==coins[j]){
                amounts[i]=1;               //可以直接用一个硬币表示出来的情况
                while((j+1)<coinSize&&coins[j+1]==coins[j]){
                    j++;                    //防止有重复的硬币
                }
                j++;
            }else{
                amounts[i]=INT_MAX;         //需要无限多枚硬币才能表示出i
            }
        }
        for(int i=2*coins[0];i<=amount;i++){            //第一个需要更新的数字至少是2*coins[0]，因为只用一枚硬币可以表示出来的amount已经全部更新了，最新更新的至少需要2枚硬币
            for(int j=coins[0];j<=(i/2>coins[coinSize-1]?coins[coinSize-1]:i/2);j++){   //比如新出现一个i是我们需要求的amount，i=min{amount==j时所需的硬币数+amount==i-j时所需要的硬币数，从coins[0]开始是因为coins[0]是最小的硬币循环到最大的硬币就可以了}
                if(amounts[j]!=INT_MAX&&amounts[i-j]!=INT_MAX){
                    if(amounts[i]>(amounts[j]+amounts[i-j])){
                        amounts[i]=amounts[j]+amounts[i-j];             //求最小的过程
                    }
                }
            }
        }
        if(amounts[amount]==INT_MAX){
            return -1;
        }else{
            return amounts[amount];
        }
    }
};