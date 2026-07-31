class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Set<String> set = new HashSet<>();
        
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            Set<Integer> set = new HashSet<>();
            set.add(nums[i]);

            for(int j = i + 1; j < nums.length; j++){
                set.add(nums[j]);
                if(set.size() == k) count++;
            }
        }
        return count;
    }
}