class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();

        for(int i=min; i<max; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        list.sort(null);
        return list;
    }
}