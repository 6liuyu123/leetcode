class Solution {
    public List<String> commonChars(String[] A) {
        int n = A.length, i, j;
        int[] times = new int[26];
        int[] tmp = new int[26];
        for (i = 0; i < 26; i++) {
            times[i] = 0;
        }
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        int sl;
        sl = A[0].length();
        for (i = 0; i < sl; i++) {
            times[A[0].charAt(i)-'a']++;
        }
        for (i = 1; i < n; i++) {
            sl = A[i].length();
            for (j = 0; j < 26; j++) {
                tmp[j] = 0;
            }
            for (j = 0; j < sl; j++) {
                tmp[A[i].charAt(j)-'a']++;
            }
            for (j = 0; j < 26; j++) {
                times[j] = times[j]>tmp[j] ? tmp[j] : times[j];
            }
        }
        char c;
        for (i = 0; i < 26; i++) {
            c = (char)(i+'a');
            for (j = 0; j < times[i]; j++) {
                res.add(String.valueOf(c)); 
            }
        }
        return res;
    }
}