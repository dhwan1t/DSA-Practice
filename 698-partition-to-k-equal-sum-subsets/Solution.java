class Solution {
    public boolean helper(int mask, int currsum, int[] nums, int req, int[] dp){
        if(mask == (1<<nums.length)-1) return true;
        if(dp[mask] != -1) return dp[mask] == 1;
        if(currsum == req) currsum = 0;

        boolean ans = false;

        for(int i=0; i<nums.length; i++){
            if((mask & (1<<i)) != 0) continue;
            if(currsum+nums[i] > req) continue;

            ans = ans || helper(mask | (1 << i), currsum+nums[i], nums, req, dp);

            if(ans) break;;
        }
        dp[mask] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i: nums) sum += i;
        if(sum%k != 0) return false;

        int req = sum/k;

        int[] dp = new int[1 << nums.length];
        Arrays.fill(dp, -1);

        return helper(0, 0, nums,req, dp);
    }
}