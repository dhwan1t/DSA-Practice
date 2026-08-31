/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        while(head != null){
            nums.add(head.val);
            head = head.next;
        }

        List<Integer> cPoints = new ArrayList<>();

        for(int i=1; i<nums.size()-1; i++){
            if(nums.get(i) > nums.get(i-1) && nums.get(i) > nums.get(i+1)){
                cPoints.add(i);
            }
            else if(nums.get(i) < nums.get(i-1) && nums.get(i) < nums.get(i+1)){
                cPoints.add(i);
            }
        }

        if(cPoints.size() < 2) return new int[] {-1, -1};

        int min = Integer.MAX_VALUE;
        int max = cPoints.get(cPoints.size()-1) - cPoints.get(0);

        for(int i=1; i<cPoints.size(); i++){
            min = Math.min(min, cPoints.get(i) - cPoints.get(i-1));
        }

        return new int[] {min, max};
    }
}