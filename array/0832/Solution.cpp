#include<vector>

using namespace std;

class Solution{
    public:
    vector<vector<int> > flipAndInvertImage(vector<vector<int> >& A){
        int tempBegin,tempEnd;
        int i,j;
        int n;
        for(vector<vector<int> >::iterator vvi=A.begin();vvi!=A.end();vvi++){
            n=(*vvi).size();
            for(i=0,j=n-1;i<=j;i++,j--){
                tempBegin=(*vvi)[i]==1?0:1;
                tempEnd=(*vvi)[j]==1?0:1;
                (*vvi)[i]=tempEnd;
                (*vvi)[j]=tempBegin;
            }
        }
        return A;
    }
};