class Solution{
    public int numTeams(int[] rating){
        int n=rating.length;
        if(n<=2){
            return 0;
        }
        int[] minToMax2=new int[n];
        int[] maxToMin2=new int[n];
        int i,j,result=0;
        for(i=0;i<n;i++){
            minToMax2[i]=0;
            maxToMin2[i]=0;
            for(j=i-1;j>=0;j--){
                if(rating[i]>rating[j]){
                    minToMax2[i]++;
                    result+=minToMax2[j];
                }
                if(rating[i]<rating[j]){
                    maxToMin2[i]++;
                    result+=maxToMin2[j];
                }
            }
        }
        return result;
    }
}