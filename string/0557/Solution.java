class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String res = "";
        char temp;
        int n = ss.length;
        int sl;
        for (int i = 0; i < n;) {
            sl = ss[i].length();
            char[] cs = ss[i].toCharArray();
            for (int j = 0; j < sl/2; j++) {
                temp = cs[j];
                cs[j] = cs[sl-1-j];
                cs[sl-1-j] = temp;
            }
            res = res.concat(new String(cs));
            i++;
            if (i != n) {
                res = res.concat(" ");
            }
        }
        return res;
    }
}