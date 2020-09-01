#include<vector>
#include<string>

using namespace std;

class Solution{
    public:
    int N;
    string tempString;
    vector<string> tempSolution;
    vector<int> board;
    vector<vector<string> > result;

    void addSolution(){
        int j;
        for(int i=0;i<N;i++){
            tempString="";
            for(j=0;j<board[i];j++){
                tempString+='.';
            }
            tempString+='Q';
            for(j=j+1;j<N;j++){
                tempString+='.';
            }
            tempSolution[i]=tempString;
        }
        result.push_back(tempSolution);
    }

    bool place(int column){
        for(int j=column-1;j>=0;j--){
            if((board[j]==board[column])||(board[j]==board[column]+j-column)||(board[j]==board[column]-j+column)){
                return false;
            }
        }
        return true;
    }

    void Nqueens(int column){
        if(column==N){
            addSolution();
            return;
        }else{
            for(int row=0;row<N;row++){
                board[column]=row;
                if(place(column)){
                    Nqueens(column+1);
                }
            }
        }
    }

    vector<vector<string> > solveNQueens(int n){
        N=n;
        tempSolution.resize(n);
        board.resize(n);
        Nqueens(0);
        return result;
    }
};