class Solution {
    public int minDistance(String word1,String word2){
        int i,j;
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][];
        for(i=0;i<=n;i++){
            dp[i]=new int[m+1];
        }

        for(i=0;i<=n;i++){
            dp[i][0]=i;
        }

        for(j=0;j<=m;j++){
            dp[0][j]=j;
        }

        for(i=1;i<=n;i++){
            for(j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;          //dp[i-1][j]+1代表删除word1[i-1],dp[i][j-1]+1代表增加一位,dp[i-1,j-1]代表替换
                }
            }
        }
        
        return dp[n][m];
    }
}