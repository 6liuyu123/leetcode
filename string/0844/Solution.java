class Solution {
    public boolean backspaceCompare(String S, String T) {
        int n1 = S.length();
        int n2 = T.length();
        char[] s1 = new char[n1];
        char[] s2 = new char[n2];
        int j1 = -1, j2 = -1;
        for (int i = 0; i < n1; i++) {
            if (S.charAt(i) == '#') {
                if (j1 == -1) {
                    continue;
                } else {
                    j1--;
                }
            } else {
                s1[++j1] = S.charAt(i);
            }
        }
        for (int i = 0; i < n2; i++) {
            if (T.charAt(i) == '#') {
                if (j2 == -1) {
                    continue;
                } else {
                    j2--;
                }
            } else {
                s2[++j2] = T.charAt(i);
            }
        }
        if (j1 != j2) {
            return false;
        } else {
            for (int i = 0; i <= j1; i++) {
                if (s1[i] != s2[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}