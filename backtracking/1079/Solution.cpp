#include<string>
#include<unordered_map>
#include<vector>

using namespace std;

class Solution{
    public:
    int mapSize,n;
    int count;
    unordered_map<char,int> tileMap;

    void countTimes(int level){
        if(level==n){
            count++;            //最后一层，肯定只有一种情况
        }else{
            for(unordered_map<char,int>::iterator i=tileMap.begin();i!=tileMap.end();i++){
                if((*i).second!=0){
                    count++;            //增加一种情况
                    (*i).second--;      //将这个字符加入
                    countTimes(level+1);//递归
                    (*i).second++;      //将字符退出
                }
            }
        }
    }

    int numTilePossibilities(string tiles){
        int i;
        count=0;
        n=tiles.size();
        char* tile=new char[n+1];
        unordered_map<char,int>::iterator it;
        strcpy(tile,tiles.c_str());
        //求出有哪些字符(解空间树的分支),每个字符出现几次
        for(i=0;i<n;i++){
            it=tileMap.find(tile[i]);
            if(it==tileMap.end()){
                tileMap.insert(pair<char,int>(tile[i],1));
            }else{
                (*it).second++;
            }
        }
        //回溯算法开始
        mapSize=tileMap.size();
        countTimes(1);
        return count;
    }
};