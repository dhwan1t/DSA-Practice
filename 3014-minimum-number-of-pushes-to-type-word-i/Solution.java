class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int cost = 1;
        int ans = 0;

        while(n > 0){
            int take = Math.min(8, n);
            ans += cost*take;
            n -= take;
            cost += 1;
        }
        return ans;
    }
}