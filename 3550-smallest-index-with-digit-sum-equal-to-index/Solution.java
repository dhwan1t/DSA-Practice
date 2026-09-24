class Solution {
    private int sum(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;  
            n = n/10;     
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == i || sum(nums[i]) == i){
                ans = Math.min(ans, i);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}