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
    public ListNode reverse(ListNode head){
        // if(head == null || head.next == null){
        //     return head;
        // }
        // ListNode revNode = reverse(head.next);
        // head.next.next = head;
        // head.next = null;
        // return revNode;
        ListNode curr = head;
        ListNode agla = head;
        ListNode prev = null;

        while(curr != null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode midOfNode = middle(head);
        ListNode left = head;
        ListNode right = midOfNode.next;
        midOfNode.next = null;

        ListNode revright = reverse(right);
        ListNode rhead = revright;
        ListNode lhead = left;

        while(lhead != null && rhead != null){
            if(lhead.val != rhead.val){
                return false;
            }
            lhead = lhead.next;
            rhead = rhead.next;
        }
        return true;
    }
}