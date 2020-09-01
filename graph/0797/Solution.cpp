#include<vector>

using namespace std;

class Solution{
    public:
    int n;
    int level;
    vector<bool> visited;
    vector<int> path;
    vector<vector<int> > nodes;
    vector<vector<int> > paths;
    
    void DFS(int node){
        visited[node]=true;
        path.push_back(node);
        if(node==n-1){
            paths.push_back(path);
        }else{
            int size=nodes[node].size();
            for(int i=0;i<size;i++){
                if(visited[nodes[node][i]]){
                    continue;
                }
                DFS(nodes[node][i]);
            }   
        }
        path.pop_back();
        visited[node]=false;
    }

    vector<vector<int> > allPathsSourceTarget(vector<vector<int> >& graph){
        if(graph.empty()){
            return graph;
        }
        level=0;
        n=graph.size();
        visited.resize(n);
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        nodes=graph;
        DFS(0);
        return paths;
    }
};