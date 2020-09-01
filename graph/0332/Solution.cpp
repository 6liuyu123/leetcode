#include<set>
#include<vector>
#include<String>

using namespace std;

class Solution{
public:
    vector<string> findItinerary(vector<vector<string> >& tickets){
        int i=0,j=0;
        string depart="JFK";
        set<string> lines;
        string temp1,temp2;
        int n=tickets.size();
        for(i=0;i<n;i++){
            temp1=tickets[i][0];
            temp2=tickets[i][1];
            if(lines.find(temp1)==lines.end()){
                lines.insert(temp1);
            }
            if(lines.find(temp2)==lines.end()){
                lines.insert(temp2);
            }
        }
    }
};