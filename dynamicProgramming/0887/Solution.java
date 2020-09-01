class Solution {
    public int superEggDrop(int K,int N){
        int[][] dp=new int[N+1][K+1];       //K个蛋，N层楼

        int i,j,min=-1,max=0,mid,down,up;

        for(i=0;i<=K;i++){
            dp[0][i]=0;                     //K个蛋，0层楼
            dp[1][i]=1;                     //K个蛋，1层楼
        }

        for(i=0;i<=N;i++){
            dp[i][0]=0;                     //i层楼0个蛋，0次
            for(j=1;j<=K;j++){
                dp[i][j]=i;                 //i层楼最多i次
            }
        }

        dp[1][0]=0;                         //1层楼，0个蛋0次

        for(i=2;i<=N;i++){
            for(j=2;j<=K;j++){
                min=1;
                max=i;
                while(min<max){
                    mid=min+(max-min+1)/2;
                    down=dp[mid-1][j-1];
                    up=dp[i-mid][j];
                    if(down>up){
                        max=mid-1;
                    }else{
                        min=mid;
                    }
                }
                dp[i][j]=dp[min-1][j-1]>dp[i-min][j]?dp[min-1][j-1]:dp[i-min][j];
                dp[i][j]++;
            }
        }

        return dp[N][K];
    }
}