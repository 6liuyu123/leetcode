#include<queue>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution{
    public:
    int minFlips(vector<vector<int> >& mat){
        int time;
        int i,j,o,p;
        int level;
        int matCount=0;
        int tmatCount;
        int m=mat.size();
        int n=mat[0].size();
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                matCount=matCount*2+mat[i][j];
            }
        }
        if(matCount==0){
            return 0;
        }
        vector<vector<int> > tMat;
        queue<vector<vector<int> > > bFlip;
        unordered_map<int,int> jFlip;
        bFlip.push(mat);
        jFlip.insert(pair<int,int>(matCount,0));
        while(!bFlip.empty()){
            mat=bFlip.front();
            bFlip.pop();
            matCount=0;
            for(o=0;o<m;o++){
                for(p=0;p<n;p++){
                    matCount=matCount*2+mat[o][p];
                }
            }
            level=(*jFlip.find(matCount)).second;
            for(i=0;i<m;i++){
                for(j=0;j<n;j++){
                    tMat=mat;
                    if(i-1>=0){
                        tMat[i-1][j]=mat[i-1][j]==1?0:1;
                    }
                    if(j-1>=0){
                        tMat[i][j-1]=mat[i][j-1]==1?0:1;
                    }
                    if(i+1<m){
                        tMat[i+1][j]=mat[i+1][j]==1?0:1;
                    }
                    if(j+1<n){
                        tMat[i][j+1]=mat[i][j+1]==1?0:1;
                    }
                    tMat[i][j]=mat[i][j]==1?0:1;
                    tmatCount=0;
                    for(o=0;o<m;o++){
                        for(p=0;p<n;p++){
                            tmatCount=tmatCount*2+tMat[o][p];
                        }
                    }
                    if(tmatCount==0){
                        return level+1;
                    }
                    if(jFlip.find(tmatCount)==jFlip.end()){
                        jFlip.insert(pair<int,int>(tmatCount,level+1));
                        bFlip.push(tMat);
                    }else{
                        continue;
                    }
                }
            }
        }
        return -1;
    }
};