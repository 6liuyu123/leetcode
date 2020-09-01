#include<vector>
#include<map>

using namespace std;

class Solution{
    public:
    vector<int> kWeakestRows(vector<vector<int> >& mat,int k){
        int m=mat.size();
        int n=mat[0].size();
        int i,j,count;
        vector<int> result(k);
        vector<int> temp;
        map<int,vector<int> > times;
        map<int,vector<int> >::iterator find,p,end;
        for(i=0;i<m;i++){
            count=0;
            for(j=0;j<n;j++){
                count+=mat[i][j];
            }
            find=times.find(count);
            if(find==times.end()){
                temp.push_back(i);
                times.insert(pair<int,vector<int> >(count,temp));
                temp.clear();
            }else{
                (*find).second.push_back(i);
            }
        }
        end=times.end();
        for(p=times.begin(),i=0;p!=end&&i<k;p++){
            count=(*p).second.size();
            for(j=0;j<count&&i<k;i++,j++){
                result[i]=(*p).second[j];
            }
        }
        return result;
    }
};