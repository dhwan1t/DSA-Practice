class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        String s = num + "";
        for(int i=0; i<4; i++){
            arr[i] = s.charAt(i) - '0';
        }
        Arrays.sort(arr);
        
        return Integer.parseInt(arr[0] + "" + arr[3]) + Integer.parseInt(arr[1] + "" + arr[2]);
    }
}