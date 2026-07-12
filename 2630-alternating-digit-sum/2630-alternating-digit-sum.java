class Solution {
    public int rev(int n){
        int x = 0;
        while(n > 0){
            x = (x * 10 )+ (n % 10);
            n /= 10;
        }
        return x;
    }
    public int alternateDigitSum(int n) {
        int sum = 0;
        int c = 1;
        n = rev(n);
        while(n > 0){
            sum += (n % 10)*c;
            n /= 10;
            c *= -1;
        }
        return sum;
    }
}