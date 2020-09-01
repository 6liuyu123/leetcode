#include<vector>

using namespace std;

class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int> >& points) {
        if(points.empty()){
            return 0;
        }
        int beginx=points[0][0];
        int beginy=points[0][1];
        int endx,endy,disx,disy;
        int dis=0;
        for(vector<vector<int> >::iterator vvi=(points.begin()++);vvi!=points.end();vvi++){
            endx=(*vvi)[0];
            endy=(*vvi)[1];
            disx=endx>beginx?endx-beginx:beginx-endx;
            disy=endy>beginy?endy-beginy:beginy-endy;
            dis+=(disx>disy?disx:disy);
            beginx=endx;
            beginy=endy;
        }
        return dis;
    }
};