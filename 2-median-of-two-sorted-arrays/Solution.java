class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        long sum = 0;

        for(int i: nums1){
            sum += i; 
        }
        for(int i: nums2){
            sum += i;
        }
        
        double ans = (double)sum / (nums1.length+nums2.length);
        return ans;
    }
}