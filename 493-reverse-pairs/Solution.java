class Solution {
    private int mergeSort(int[] nums, int l, int h){
        if(l >= h) return 0;
        int mid= l+(h-l)/2;
        int count = mergeSort(nums, l, mid);
        count += mergeSort(nums, mid+1, h);
        count += countPairs(nums, l, mid, h);
        merger(nums, l, mid, h);
        return count;
    }
    private void merger(int[] nums, int l, int mid, int h){
        List<Integer> temp = new ArrayList<>();
        int left = l;
        int right = mid+1;

        while(left <= mid && right <= h){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }

        while(left <= mid) temp.add(nums[left++]);
        while(right <= h) temp.add(nums[right++]);

        for(int i=l; i<=h; i++){
            nums[i] = temp.get(i-l);
        }
    }
    private int countPairs(int[] nums, int l, int mid, int h){
        int count = 0;
        int right = mid+1;
        
        for(int i=l; i<=mid; i++){
            while(right <= h && nums[i] > 2*nums[right])right++;
            count += right-(mid+1);
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}