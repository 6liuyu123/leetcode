class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z){
            return false;
        }
        if(x==0||y==0){
            return z==0||z==x+y;
        }
        int temp;
        if(x<y){
            temp=x;
            x=y;
            y=temp;
        }
        while(x%y!=0){
            temp=y;
            y=x%y;
            x=temp;
        }
        return z%y==0;
    }
}