#include<queue>

using namespace std;

class RecentCounter{
    private:
    queue<int> qi;
    public:
    RecentCounter() {
        
    }
    
    int ping(int t) {
        qi.push(t);
        while(t-qi.front()>3000){
            qi.pop();
        }
        return qi.size();
    }
};