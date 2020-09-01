class Solution {
public:
    int subtractProductAndSum(int n) {
        if(n<10){
            return 0;
        }
        int product=1;
        int sum=0;
        int temp;
        while(n!=0){
            temp=n%10;
            product*=temp;
            sum+=temp;
            n/=10;
        }
        return product-sum;
    }
};