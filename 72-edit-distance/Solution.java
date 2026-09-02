class Solution {
    public int helper(int i, int j, String s, String t, int[][] dp){
        if(i == s.length()) return t.length()-j;
        if(j == t.length()) return s.length()-i;
        if(i >= s.length() || j >= t.length()) return 0;

        if(s.charAt(i) == t.charAt(j)) return helper(i+1, j+1, s, t, dp);

        if(dp[i][j] != -1) return dp[i][j];

        int insert = 1+helper(i, j+1, s, t, dp);
        int delete = 1+helper(i+1, j, s, t, dp);
        int swap = 1+helper(i+1, j+1, s, t, dp);

        dp[i][j] = Math.min(insert, Math.min(delete, swap));
        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return helper(0, 0, word1, word2, dp);
    }
}