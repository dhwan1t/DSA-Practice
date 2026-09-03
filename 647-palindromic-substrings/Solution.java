class Solution {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 1;
            }
        }
        int count = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(dp[i][j] == 1) count++;
            }
        }
        
        return count;
    }
}