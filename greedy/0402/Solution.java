class Solution {
 public String removeKdigits(String num, int k) {
     int n = num.length(), i, j;
     if (n <= k) {
         return "0";
     }
     StringBuffer buf = new StringBuffer(num);
     for (i = 0, j = 0; i < k; i++) {
         for (j = 0; j < n-i-1; j++) {
             if (buf.charAt(j) > buf.charAt(j+1)) {
                 break;
             }
         }
         if (j < n-i-1) {
             buf.replace(j, n-i, buf.substring(j+1, n-i));
         }
     }
     for (i = 0; i < n-k; i++) {
         if (buf.charAt(i) != '0') {
             break;
         }
     }
     if (i == n-k) {
         return "0";
     }
     return buf.substring(i, n-k);
 }
}