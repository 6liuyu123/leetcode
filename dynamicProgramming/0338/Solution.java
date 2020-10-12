class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <=num) {
                res[i+b] = res[i]+1;
                i++;
            }
            i=0;
            b*=2;
        }
        return res;
    }
}