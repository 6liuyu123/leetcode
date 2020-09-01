//参考快速排序的思想

#include<iostream>
#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> sortArrayByParity(vector<int>& A){
        int n=A.size();
        int i=0,j=n-1;
        int temp;
        while(i<j){
            while(A[i]%2==0&&i<j){
                i++;
            }
            while(A[j]%2==1&&i<j){
                j--;
            }
            temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
        return A;
    }
};