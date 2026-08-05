class Solution {
    private void subset(int[] nums, List<Integer> sums, int currentSum, int index) {
        if (index == nums.length) {
            sums.add(currentSum);
            return;
        }
        
        subset(nums, sums, currentSum + nums[index], index + 1);
        subset(nums, sums, currentSum, index + 1);
    }

    private int lowerBound(List<Integer> list, int target){
        int l = 0, h = list.size()-1;
        int out = list.size();

        while(l <= h){
            int mid = l+(h-l)/2;

            if(list.get(mid) >= target){
                out = mid;
                h = mid - 1; 
            }
            else{
                l = mid + 1;
            }
        }
        return out;
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;

        int[] a = Arrays.copyOfRange(nums, 0, n/2);
        int[] b = Arrays.copyOfRange(nums, n/2, n);

        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();

        subset(a, s1, 0, 0);
        subset(b, s2, 0, 0);
        Collections.sort(s2);

        int ans = Integer.MAX_VALUE;

        for(int x : s1){
            int target = goal-x;

            int idx = lowerBound(s1, target);

            if(idx < s2.size()) ans = Math.min(ans, Math.abs(x + s2.get(idx) - goal));
            if(idx > 0) ans = Math.min(ans, Math.abs(x + s2.get(idx - 1) - goal));
            if(ans == 0) return 0;
        }
        return ans;
    }
}