// class Solution {
//     public List<Integer> goodDaysToRobBank(int[] sec, int time) {
//         List<Integer> list = new ArrayList<>();
//         for(int i=time; i<sec.length-time; i++){
//             int j= i - 1;
//             int k= i + 1;
            
//             while(j >= i - time && j >= 0 && sec[j] >= sec[j + 1]){
//                 j--;
//             }
//             if(j > i - time - 1) j = i;
                
//             while(k <= i + time && k < sec.length && sec[k] >= sec[k - 1]){
//                 k++;
//             }
            
//             if(k < i + time + 1) k = i;
//             if(i != j && i != k && j != k){
//                 list.add(i);
//             }         
//         }
//         return list;
//     }
// }


class Solution {
    public List<Integer> goodDaysToRobBank(int[] sec, int time) {
        int n = sec.length;
        List<Integer> ans = new ArrayList<>();
        if(time == 0){
            for(int i = 0; i < n; i++){
                ans.add(i);
            }
            return ans;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 1; i < n; i++){
            if(sec[i] <= sec[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(sec[i] <= sec[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }

        for(int i = time; i < n - time; i++){
            if(left[i] >= time && right[i] >= time){
                ans.add(i);
            }
        }
        return ans;
    }
}