class Solution {
    public int[] sortedSquares(int[] A) {
       int n = A.length();
       int[] res = new int[n];
       int i = 0, j = n-1, k = n-1;
       while (i < j) {
           if (A[i]*A[i] < A[j]*A[j]) {
               res[k--] = A[j]*A[j--];
           } else {
               res[k--] = A[i]*A[i++];
           }
       }
       return res;
    }
}