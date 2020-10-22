class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] m = new int[26];
        int i, n = s.length(), p = -1, tmp = 0;
        List<Integer> res = new ArrayList<>();
        for (i = 0; i < 26; i++) {
            m[i] = -1;
        }
        for (i = 0; i < n; i++) {
            m[s.charAt(i)-'a'] = i;
        }
        for (i = 0; i < n; i++) {
            if (p == -1) {
                p = m[s.charAt(i)-'a'];
                tmp = 1;
            } else {
                if (p < i) {
                    res.add(tmp);
                    p = m[s.charAt(i)-'a'];
                    tmp = 1;
                } else {
                    if (p < m[s.charAt(i)-'a']) {
                        p = m[s.charAt(i)-'a'];
                    }
                    tmp++;
                }
            }
        }
        res.add(tmp);
        return res;
    }
}