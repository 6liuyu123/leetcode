class Solution {
    public boolean[] judge=new boolean[80001];
    public int minIncrementForUnique(int[] A) {
        int i;
        int n=A.length;
        int result=0;
        for(i=0;i<=80000;i++){
            judge[i]=false;
        }
        for(i=0;i<n;i++){
            if(judge[A[i]]){
                A[i]++;
                i--;
                result++;
            }else{
                judge[A[i]]=true;
            }
        }
        return result;
    }
}