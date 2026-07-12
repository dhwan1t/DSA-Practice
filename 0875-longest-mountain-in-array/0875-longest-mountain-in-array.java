class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length<3) return 0;
        
        int res = 0;
        int i = 0; 
        int n = arr.length;
        while(i<n){
            int j = i;
            while(j < n - 1 && arr[j] < arr[j + 1]){
                j++;
            }
            int k = j;
            while(k < n - 1 && arr[k] > arr[k + 1]){
                k++;
            }
            if(i != j && j != k){
                res = Math.max(res, k-i+1);
            }
            i = k; 
            if(i == j && j == k) i++;   
        }
        return res;
    }
}