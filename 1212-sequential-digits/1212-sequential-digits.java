class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            int num = 0;
            for(int j=i; j<=9; j++){
                num = num*10+j;
                if(num <= high && num >= low) list.add(num);
            }
        }
        Collections.sort(list);
        return list;
    }
}