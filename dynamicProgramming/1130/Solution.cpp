#include<vector>

using namespace std;

class Solution{
    public:
    int mctFromLeafValues(vector<int>& arr){
        if(arr.empty()){
            return 0;
        }
        int n=arr.size();
        int **min=new int*[n];              //min矩阵记录从arr数组第i个元素到第j个元素最优解
        int **maxLeaf=new int*[n];          //maxLeaf矩阵记录从第i个元素到第j个元素的最大叶子
        int tempMin,tempMaxLeaf;            //用于找到min[i][j]=min{min[i][j-k]+min[i+k][j]+arr[i][j-k]*arr[i+k][j]}
        int tempTotal;
        for(int i=0;i<n;i++){
            min[i]=new int[n];
            maxLeaf[i]=new int[n];
        }
        for(int i=0;i<n;i++){
            min[i][i]=0;
            maxLeaf[i][i]=arr[i];
        }
        for(int i=0;i<n-1;i++){
            min[i][i+1]=arr[i]*arr[i+1];
            maxLeaf[i][i+1]=arr[i]>arr[i+1]?arr[i]:arr[i+1];    //初始化第一条斜边
        }
        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                tempMin=INT_MAX;
                for(int k=0;k<i;k++){
                    tempTotal=min[j][j+i-k-1]+min[j+i-k][j+i]+maxLeaf[j][j+i-k-1]*maxLeaf[j+i-k][j+i];
                    if(tempTotal<tempMin){
                        tempMin=tempTotal;
                        tempMaxLeaf=maxLeaf[j][j+i-k-1]>maxLeaf[j+i-k][j+i]?maxLeaf[j][j+i-k-1]:maxLeaf[j+i-k][j+i];
                    }
                }
                min[j][j+i]=tempMin;
                maxLeaf[j][j+i]=tempMaxLeaf;
            }
        }
        return min[0][n-1];
    }
};