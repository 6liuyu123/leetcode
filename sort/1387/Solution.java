class Solution {
    
    public int kValue(int i) {
        int j = 0;
        while(i != 1) {
            if(i%2 == 0) {
                i /= 2;
            } else {
                i = (3*i)+1;
            }
            j++;
        }
        return j;
    }
    
    public void adjustHeap(int[][] arr, int i, int k) {
        int temp0 = arr[i][0];
        int temp1 = arr[i][1];
        for(int j = i*2+1; j < k; j = j*2+1) {
            if (j+1 < k && ((arr[j][1] < arr[j+1][1]) || (arr[j][1] == arr[j+1][1] && arr[j][0] < arr[j+1][0]))) {
                j++;
            }
            if (temp1 < arr[j][1]) {
                arr[i][0] = arr[j][0];
                arr[i][1] = arr[j][1];
                i = j;
            } else if (temp1 == arr[j][1]) {
                if(temp0 < arr[j][0]) {
                    arr[i][0] = arr[j][0];
                    arr[i][1] = arr[j][1];
                    i = j;
                } else {
                    break;
                }
            }else {
                break;
            }
        }
        arr[i][0] = temp0;
        arr[i][1] = temp1;
    }

    public void createHeap(int[][] arr, int k) {
        for(int j = k/2-1; j >= 0; j--) {
            adjustHeap(arr, j, k);
        }
    }

    public int getKth(int lo, int hi, int k) {
        int i = 0, j;
        int[][] myHeap = new int[k][2];
        for(i = 0; i < k; i++){
            myHeap[i][0] = lo+i;
            myHeap[i][1] = kValue(lo+i);
        }
        createHeap(myHeap, k);
        for(; i < hi - lo + 1; i++) {
            j = kValue(lo+i);
            if (j < myHeap[0][1]){
                myHeap[0][0] = lo+i;
                myHeap[0][1] = j;
                adjustHeap(myHeap, 0, k);
            }
        }
        return myHeap[0][0];
    }
}