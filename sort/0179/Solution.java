class Solution {
    class myComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length() || s1.charAt(0) != s2.charAt(0)) {
                return -s1.compareTo(s2);
            }
            int n = s1.length() > s2.length() ? s2.length() : s1.length();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return -s1.compareTo(s2);
                }
            }
            if (s1.length() > n) {
                return compare(s1.substring(n), s2);
            } else {
                return compare(s1, s2.substring(n));
            }
        }
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return "0";
        }
        String[] num = new String[n];
        for (int i = 0; i < n; i++) {
            num[i] = String.valueOf(nums[i]);
        }
        myComparator m = new myComparator();
        Arrays.sort(num, 0, n, m);
        String res = "";
        for (int i = 0; i < n; i++) {
            res += num[i];
        }
        return res;
    }
}