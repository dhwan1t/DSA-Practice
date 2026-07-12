class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = arr.clone();
        Arrays.sort(out);
        map.put(out[0], 1);
        int r = 1;
        
        for(int i=1; i<arr.length; i++){
            if(out[i] != out[i-1]){
                r++;
            }
            map.put(out[i], r);
        }
        for(int i=0; i<arr.length; i++){
            out[i] = map.get(arr[i]);
        }
        return out;
    }
}