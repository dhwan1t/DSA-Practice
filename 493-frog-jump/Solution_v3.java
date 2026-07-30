class Solution {
    Map<Integer, Integer> map;
    int[][] dp;
    public boolean helper(int[] stones, int i, int k){
        if(i == stones.length-1) return true;
        boolean ans = false;
        
        // if(dp[i][k] != -1) return dp[i][k] == 1;
        if(dp[i][k] != -1) return dp[i][k] == 1 ? true : false;
        
        if(map.containsKey(stones[i] + k + 1) ){
            ans = ans || helper(stones, map.get(stones[i] + k + 1), k + 1);
        }
        if(map.containsKey(stones[i] + k) ){
            ans = ans || helper(stones, map.get(stones[i] + k), k);
        }
        if(map.containsKey(stones[i] + k - 1) && k-1 != 0){ // important condition for insuring no loops
            ans = ans || helper(stones, map.get(stones[i] + k - 1), k - 1);
        }    
        dp[i][k] = ans ? 1 : 0;
        return ans;
    }
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        map = new HashMap<>();
        
        dp = new int[stones.length][stones.length+1];
        
        for(int[] i: dp) Arrays.fill(i, -1);
        
        for(int i=1; i<stones.length; i++){
            map.put(stones[i], i);
        }
        
        return helper(stones, 1, 1);
    }
}