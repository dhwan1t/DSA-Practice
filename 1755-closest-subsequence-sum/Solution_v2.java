import java.util.*;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();

        helper(nums, 0, mid, 0L, left);
        helper(nums, mid, n, 0L, right);

        Collections.sort(right);

        long ans = Long.MAX_VALUE;

        for (long x : left) {
            long target = goal - x;

            int idx = Collections.binarySearch(right, target);
            if (idx >= 0) return 0;

            idx = -idx - 1;

            if (idx < right.size()) {
                ans = Math.min(ans, Math.abs(x + right.get(idx) - goal));
            }

            if (idx > 0) {
                ans = Math.min(ans, Math.abs(x + right.get(idx - 1) - goal));
            }
        }

        return (int) ans;
    }

    private void helper(int[] nums, int start, int end, long sum, List<Long> list) {
        if (start == end) {
            list.add(sum);
            return;
        }

        helper(nums, start + 1, end, sum, list);
        helper(nums, start + 1, end, sum + nums[start], list);
    }
}
