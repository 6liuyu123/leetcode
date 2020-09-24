class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        boolean findWord = false;
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (findWord) {
                    break;
                }
            } else {
                findWord = true;
                res++;
            }
        }
        return res;
    }
}