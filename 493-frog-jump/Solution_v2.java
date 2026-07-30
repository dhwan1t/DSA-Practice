class Solution {
    Map<Integer, Integer> map;
    public boolean helper(int[] stones, int i, int k){
        if(i == stones.length-1) return true;
        boolean ans = false;
        
        if(map.containsKey(stones[i] + k + 1) ){
            ans = ans || helper(stones, map.get(stones[i] + k + 1), k + 1);
        }
        if(map.containsKey(stones[i] + k) ){
            ans = ans || helper(stones, map.get(stones[i] + k), k);
        }
        if(map.containsKey(stones[i] + k - 1) && k-1 != 0){ // important condition for insuring no loops
            ans = ans || helper(stones, map.get(stones[i] + k - 1), k - 1);
        }    
        return ans;
    }
    public boolean canCross(int[] stones) {
        map = new HashMap<>();
        
        for(int i=1; i<stones.length; i++){
            map.put(stones[i], i);
        }
        return helper(stones, 1, 1);
    }
}