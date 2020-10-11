class Solution{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();        
        if(nums==null || nums.length<4) {
            return res;
        }
        int n = nums.length;
        int a, b, c, d;
        long tmp;
        Arrays.sort(nums);
        for (a=0; a<n-3; a++) {
            if (a>0 && nums[a-1]==nums[a]) {
                continue;
            }
            if (nums[a]+nums[a+1]+nums[a+2]+nums[a+3] > target) {
                break;
            }
            if (nums[a]+nums[n-3]+nums[n-2]+nums[n-1] < target) {
                continue;
            }
            for (b=a+1; b<n-2; b++) {
                if (b>a+1 && nums[b]==nums[b-1]) {
                    continue;
                }
                if (nums[a]+nums[b]+nums[b+1]+nums[b+2] > target) {
                    break;
                }
                if (nums[a]+nums[b]+nums[n-2]+nums[n-1] < target) {
                    continue;
                }
                c = b+1;
                d = n-1;
                while(c<d) {
                    tmp = nums[a]+nums[b]+nums[c]+nums[d];
                    if (tmp == target) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        temp.add(nums[d]);
                        res.add(temp);
                        while (c<d && nums[c]==nums[c+1]){
                            c++;
                        }
                        c++;
                        while (c<d && nums[d]==nums[d-1]){
                            d--;
                        }
                        d--;
                    } else if(tmp < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}