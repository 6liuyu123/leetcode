class Solution{
    public boolean hasGroupsSizeX(int[] deck){
        int i,j,n=deck.length;
        int[] deckHash=new int[10001];
        for(i=0;i<n;i++){
            deckHash[deck[i]]++;
        }
        int min=Integer.MAX_VALUE;
        for(i=0;i<=10000;i++){
            if(deckHash[i]==0){
                continue;
            }
            if(min>deckHash[i]){
                min=deckHash[i];
            }
        }
        for(i=2;i<=min;i++){
            for(j=0;j<=10000;j++){
                if(deckHash[j]%i!=0){
                    break;
                }
            }
            if(j==10001){
                return true;
            }
        }
        return false;
    }
}