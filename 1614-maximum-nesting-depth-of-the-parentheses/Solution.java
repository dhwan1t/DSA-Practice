class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int depth = 0;
        for(char c : s.toCharArray()){
            if(c== '(')depth++;
            else if(c == ')')depth--;
            ans = Math.max(ans, depth);
        }
        return ans;
    }
}