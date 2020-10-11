class Solution {
    public void heapInsert(int[] arr) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        int i, j, index, temp0;
        int n = nums.length;
        int[] res = new int[k];
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (i = 0; i < n; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i])++);
            } else {
                m.put(nums[i], 1);
            }
        }
        List<List<Integer>> heap = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (heap.size() < k) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(entry.getKey());
                tmp.add(entry.getValue());
                heap.add(tmp);
                index = heap.length() - 1;
                while (index > 0) {
                    if (heap.get(index/2).get(1) > heap.get(index).get(1)) {
                        heap.set(index, heap.get(index/2));
                        heap.set(index/2, tmp);
                        index /= 2;
                    } else {
                        break;
                    }
                }
            } else {
                if (heap.get(0).get(1) < entry.getValue()) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(entry.getKey());
                    tmp.add(entry.getValue());
                    heap.set(0, tmp);
                    j = 0;
                    temp0 = 0;
                    while (j = j*2+1; j < k; j = j*2+1) {
                        if (j+1 < k && heap.get(j).get(1) > heap.get(j).get(1)) {
                            j++;
                        }
                        if (heap.get(j).get(1) > tmp.get(1)) {
                            break;
                        } else {
                            heap.set(temp0, heap.get(j));
                            temp0 = j;
                        }
                    }
                    heap.set(temp0, tmp);
                }
            }
        }
        for (i = 0; i < k; i++) {
            res[i] = heap.get(i).get(0);
        }
        return res;
    }
}