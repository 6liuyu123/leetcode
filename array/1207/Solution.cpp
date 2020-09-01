#include<vector>
#include<unordered_map>
#include<unordered_set>

using namespace std;

class Solution{
    public:
    bool uniqueOccurrences(vector<int>& arr){
        unordered_map<int,int> arrTimes;
        unordered_map<int,int>::iterator temp;
        unordered_set<int> judgeUnique;
        for(vector<int>::iterator it=arr.begin();it!=arr.end();it++){
            temp=arrTimes.find(*it);
            if(temp==arrTimes.end()){
                arrTimes.insert(pair<int,int>(*it,1));
            }else{
                arrTimes[*it]++;
            }
        }
        unordered_map<int,int>::iterator end=arrTimes.end();
        unordered_set<int>::iterator find;
        for(temp=arrTimes.begin();temp!=end;temp++){
            find=judgeUnique.find(temp->second);
            if(find==judgeUnique.end()){
                judgeUnique.insert(temp->second);
            }else{
                return false;
            }
        }
        return true;
    }
};