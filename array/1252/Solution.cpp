#include<vector>

using namespace std;

class Solution {
public:
    int oddCells(int n, int m, vector<vector<int> >& indices) {
        int** matrix=new int*[n];
        int addx,addy,i,j;
        int count=0;
        for(int i=0;i<n;i++){
            matrix[i]=new int[m];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=0;
            }
        }
        for(vector<vector<int> >::iterator vvi=indices.begin();vvi!=indices.end();vvi++){
            addx=(*vvi)[0];
            addy=(*vvi)[1];
            for(i=0;i<m;i++){
                matrix[addx][i]++;
            }
            for(i=0;i<n;i++){
                matrix[i][addy]++;
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(matrix[i][j]%2==1){
                    count++;
                }
            }
        }
        return count;
    }
};