class Solution {
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }

        return sum;
    }
}