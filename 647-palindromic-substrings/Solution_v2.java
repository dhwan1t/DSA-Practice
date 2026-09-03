class Solution {
    public int countSubstrings(String s) {
        // int[][] dp = new int[s.length()][s.length()];

        // for(int i=0; i<s.length(); i++){
        //     for(int j=i; j<s.length(); j++){
        //         if(s.charAt(i) == s.charAt(j)) dp[i][j] = 1;
        //     }
        // }

        // int count = 0;

        // for(int i=0; i<s.length(); i++){
        //     for(int j=i; j<s.length(); j++){
        //         if((dp[i][j] == 1) && dp[j][i] == 1) count++;
        //     }
        // }
        
        // return count;

        int[][] dp = new int[s.length()][s.length()];
        int i=0;
        int j=0;

        while(j < s.length()){
            dp[i][j] = 1;
            i++;
            j++;
        }

        i=0;
        j=1;
    
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)) dp[i][j] = 1;
            i++;
            j++;
        }

        i=0;
        j=2;

        while(j < s.length()){
            int nj = j;
            i = 0;

            while(nj < s.length()){
                if(s.charAt(i) == s.charAt(nj) && dp[i+1][nj-1] == 1){
                    dp[i][nj] = 1;
                }
                i++;
                nj++;
            }
            j++;
        }

        int count = 0;

        for(int k=0; k<s.length(); k++){
            for(int l=k; l<s.length(); l++){
                if(dp[k][l] == 1) count++;
            }
        }
        
        return count;
    }
}