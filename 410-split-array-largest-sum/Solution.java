class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for(int i: nums){
            start = Math.max(start, i);
            end += i;
        }

        while(start < end){
            int mid = start+(end-start)/2;
            int sum = 0;
            int sub = 1;

            for(int i : nums){
                if(sum+i > mid){
                    sum = i;
                    sub++;
                }
                else{
                    sum += i;
                }
            }
            
            if(sub > k){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}