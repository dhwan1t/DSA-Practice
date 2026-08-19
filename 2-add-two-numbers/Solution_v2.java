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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        
        while(temp1 != null || temp2 != null){
            int a = 0, b = 0;
            if(temp1 != null)
             a = temp1.val;
            if(temp2 != null)
             b = temp2.val;
            
            int sum = a + b + carry;
            carry = sum/10;
            
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = node;
            
            if(temp1 != null)
                temp1 = temp1.next;
            if(temp2 != null)
                temp2 = temp2.next;
        }
        // while(temp1 != null){
        //     int a = temp1.val + carry;
        //     carry = a/10;
        //     ListNode node = new ListNode(a % 10);
        //     temp.next = node;
        //     temp = node;
        //     temp1 = temp1.next;
        // }
        // while(temp2 != null){
        //     int a = temp2.val + carry;
        //     carry = a/10;
        //     ListNode node = new ListNode(a % 10);
        //     temp.next = node;
        //     temp = node;
        //     temp2 = temp2.next;
        // }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        return head.next;
    }
}