class Solution {
    public boolean canReach(int[] start, int[] target) {
        int sums = start[0]+start[1];
        int sumt = target[0]+target[1];
        int mods = sums%2;
        int modt = sumt%2;
        return mods==modt;
    }
}