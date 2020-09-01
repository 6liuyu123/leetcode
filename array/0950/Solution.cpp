#include<vector>
#include<algorithm>

using namespace std;

class Solution{
    public:
    vector<int> deckRevealedIncreasing(vector<int>& deck){
        if(deck.empty()){
            return deck;
        }
        bool reveal;
        int i,j;
        int n=deck.size();
        vector<int> result(n);
        vector<bool> visit(n);
        sort(deck.begin(),deck.end());
        for(i=0;i<n;i++){
            visit[n]=false;         //每一张牌都还没翻开
        }
        for(i=0;i<n;i+=2){
            visit[i]=true;
            result[i]=deck[i/2];
        }
        i=n%2==0?n/2:i/2;
        reveal=n%2==0?false:true;
        for(;i<n;){
            for(j=1;j<n;j+=2){
                if(!reveal){
                    if(!visit[j]){
                        reveal=true;
                        visit[j]=true;
                        result[j]=deck[i];
                        i++;
                    }else{
                        continue;
                    }
                }else{
                    if(!visit[j]){
                        reveal=false;
                    }else{
                        continue;
                    }
                }
            }
        }
        return result;
    }
};