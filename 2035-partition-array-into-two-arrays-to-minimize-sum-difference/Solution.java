class Solution {
    private List<List<Integer>> subsetSum(int l, int r, int[] nums, int n){
        List<List<Integer>> res = new ArrayList<>() ;

        for(int i = 0 ; i <= n ; i ++) res.add(new ArrayList<>());

        int len = r-l+1;
        int total = 1 << len;

        for(int i=0; i<total; i++){
            int sum = 0;
            int bits = 0;

            for(int j=0; j<len; j++){
                if((i & (1 << j)) != 0){
                    sum += nums[l+j];
                    bits++;
                }
            }
            res.get(bits).add(sum);
        }

        for(int i=0; i<=n; i++) Collections.sort(res.get(i));
        return res;
    }

    private int binarySearch(List<Integer> list, int target){
        Integer r1 = upperBound(list, target);
        Integer r2 = lowerBound(list, target);

        if(r1 == null) return r2;
        if(r2 == null) return r1;

        return Math.abs(target-r1) > Math.abs(target-r2) ? r2 : r1;
    }

    private Integer upperBound(List<Integer> list, int target){
        int l=0, h=list.size()-1;
        Integer ans = null;

        while(l <= h){
            int mid = l+(h-l)/2;

            if(list.get(mid) >= target){
                ans = list.get(mid);
                h = mid-1;
            }
            else l = mid+1;

        }
        return ans;
    }

    private Integer lowerBound(List<Integer> list, int target){
        int l=0, h=list.size()-1;
        Integer ans = null;

        while(l <= h){
            int mid = l+(h-l)/2;

            if(list.get(mid) <= target){
                ans = list.get(mid);
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return ans;
    }

    public int minimumDifference(int[] nums) {
        int n = nums.length/2;

        List<List<Integer>> left = subsetSum(0, n-1, nums, n);
        List<List<Integer>> right = subsetSum(n, 2*n-1, nums, n);

        int sum = 0;
        for(int i: nums) sum += i;
        int half = sum/2;
        int out = Integer.MAX_VALUE;

        for(int i=0; i<=n; i++){
            for(int j1: left.get(i)){
                int target = half-j1;
                
                int j2 = binarySearch(right.get(n-i), target);
                int thisSum = j1+j2;
                out = Math.min(out, Math.abs(sum - 2 * thisSum));
            }
        }
        return out;
    }
}