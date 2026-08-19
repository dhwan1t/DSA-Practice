class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        Arrays.sort(rs, (a, b) -> {
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            else return a[0]-b[0];
        });

        Set<Integer> set = new HashSet<>();
        for(int[] i: rs){
            set.add(i[0]);
        }

        int ans = (n-set.size()) * 2;
        
        for(int i=0; i<rs.length; i++){
            boolean left = true;
            boolean mid = true;
            boolean right = true;

            int row = rs[i][0];
            while(i < rs.length && rs[i][0] == row ){
                int[] arr = rs[i];
                if(arr[1] >= 2 && arr[1] <= 5) left = false;
                if(arr[1] >= 4 && arr[1] <= 7) mid = false;
                if(arr[1] >= 6 && arr[1] <= 9) right = false;
                i++;
            }

            if(left && right) ans += 2;
            else if(left || right || mid) ans += 1;
            i--;
            
        }
        return ans;
    }
}