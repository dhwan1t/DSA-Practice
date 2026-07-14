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
    public ListNode rev(ListNode head){
        ListNode curr = head;
        ListNode aage = head;
        ListNode prev = null;

        while(curr != null){
            aage = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aage;
        }
        return prev;
    }
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode midNode = mid(head);
        ListNode left = head;
        ListNode right = midNode.next;
        midNode.next = null;

        ListNode rev = rev(right);
        ListNode rhead =  rev;
        ListNode lhead = left;

        while(lhead != null && rhead != null){
            if(lhead.val != rhead.val) return false;
            lhead = lhead.next;
            rhead = rhead.next;
        }
        return true;
    }
}