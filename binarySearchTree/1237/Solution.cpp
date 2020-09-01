#include<vector>
#include"CustomFunctioin.cpp"

using namespace std;

class Solution{
    public:
    vector<vector<int> > result;
    vector<int> temp;
    int FindY(CustomFunction& c,int x,int yi,int yj,int z){
        int mid;
        while(yi<=yj){
            mid=(yi+yj)/2;
            if(c.f(x,mid)==z){
                return mid;
            }else if(c.f(x,mid)<z){
                yi=mid+1;
            }else{
                yj=mid-1;
            }
        }
        return mid;
    }
    void FindX(CustomFunction& c,int xi,int xj,int yi,int yj,int z){
        if(xi>xj||yi>yj){
            return;
        }
        int mid=(xi+xj)/2;
        if(c.f(mid,z)<z){
            FindX(c,mid+1,z,yi,yj,z);
        }else if(c.f(mid,0)>z){           
            FindX(c,1,mid-1,yi,yj,z);
        }else{
            int y=FindY(c,mid,yi,yj,z);
            if(c.f(mid,y)!=z){
                FindX(c,xi,mid-1,y,yj,z);
                FindX(c,mid+1,xj,yi,y,z);
            }else{
                temp[0]=mid;
                temp[1]=y;
                result.push_back(temp);
                FindX(c,xi,mid-1,y+1,yj,z);
                FindX(c,mid+1,xj,yi,y-1,z);
            }
        }
    }
    vector<vector<int> > findSolution(CustomFunction& customfunction,int z){
        temp.resize(2);
        FindX(customfunction,1,z,1,z,z);
        return result;
    }
};