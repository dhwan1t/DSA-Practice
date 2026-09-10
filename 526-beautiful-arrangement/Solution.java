class Solution {
    public int helper(int pos, int n, int[] arr){
        if(pos > n) return 1;

        int res = 0;
        for(int i=1; i<=n; i++){
            if(arr[i] == 0 && (pos%i == 0 || i%pos == 0)){
                arr[i] = 1;
                res += helper(pos+1, n, arr);
                arr[i] = 0;
            }
        }
        return res;
    }
    public int countArrangement(int n) {
        return helper(1, n, new int[n+1]);
    }
}