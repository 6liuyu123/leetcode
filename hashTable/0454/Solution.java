class Solution {
 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
   Map<Integer, Integer> mAB = new HashMap<Integer, Integer>();
   Map<Integer, Integer> mCD = new HashMap<Integer, Integer>();
   int n = A.length;
   int i, j, tmpKey;
   int res = 0;
   for (i = 0; i < n; i++) {
     for (j = 0; j < n; j++) {
       mAB.put(A[i]+B[j], mAB.getOrDefault(A[i]+B[j], 0) + 1);
     }
   }
   for (i = 0; i < n; i++) {
     for (j = 0; j < n; j++) {
       res += mAB.getOrDefault(-C[i]-D[j], 0);
     }
   }
   return res;
 }
}