#include<vector>
#include<unordered_map>

using namespace std;

class Solution{
    public:
    vector<vector<int> > groupThePeople(vector<int>& groupSizes){
        unordered_map<int,vector<int> > timeIndexs;
        vector<vector<int> > result;
        int n=groupSizes.size();
        int m;
        int i,j,vi;
        int index;
        vector<int> temp;
        unordered_map<int,vector<int> >::iterator p;
        unordered_map<int,vector<int> >::iterator q;
        for(i=0;i<n;i++){
            p=timeIndexs.find(groupSizes[i]);
            if(p==timeIndexs.end()){
                temp.push_back(i);
                timeIndexs.insert(pair<int,vector<int> >(groupSizes[i],temp));
                temp.clear();
            }else{
                (*p).second.push_back(i);
            }
        }
        q=timeIndexs.end();
        for(p=timeIndexs.begin();p!=q;p++){
            index=(*p).first;
            vi=(*p).second.size();
            for(j=0;j<vi;j+=index){
                for(i=j;i<j+index;i++){
                    temp.push_back((*p).second[i]);
                }
                result.push_back(temp);
                temp.clear();
            }
        }
        timeIndexs.clear();
        return result;
    }
};