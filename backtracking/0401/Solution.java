class Solution {
<<<<<<< HEAD
=======
<<<<<<< HEAD

    List<String> res = new ArrayList<>();
    int[] time = {1,2,4,8,1,2,4,8,16,32};
    boolean[] judge = {false, false, false, false, false, false, false, false, false, false};

    public void countTime(int n, int k) {
        if (n == 0) {
            int hours = 0, minutes = 0;
            for (int i = 0; i < 4; i++) {
                if (judge[i]) {
                    hours += time[i];
                }
            }
            for (int i = 4; i < 10; i++) {
                if (judge[i]) {
                    minutes += time[i];
                }
            }
            if (hours > 11 || minutes > 59) {
                return;
            }
            if (minutes < 10) {
                res.add(String.valueOf(hours) + ":0" + String.valueOf(minutes));
            } else {
                res.add(String.valueOf(hours) + ":" + String.valueOf(minutes));
            }
        } else {
            judge[k] = true;
            countTime(n-1, k+1);
            judge[k] = false;
            if (k+n < 10) {
                countTime(n, k+1);
            }
        }
    } 

    public List<String> readBinaryWatch(int num) {
        countTime(num, 0);
        return res;
    }
=======
>>>>>>> 0.0.0 commit
    int[] hours = {1,2,4,8};
    int[] minutes = {1,2,4,8,16,32};

    public 
<<<<<<< HEAD
=======
>>>>>>> 1547b917225c55cd12ba33d9c6140433dcef76ab
>>>>>>> 0.0.0 commit
}