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
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(null != l1 || null != l2 || carry > 0) {
            int l1_val = null != l1 ? l1.val : 0;
            int l2_val = null != l2 ? l2.val : 0;
            int sum = l1_val + l2_val + carry;
            carry = sum / 10;
            int list_num = sum % 10;
            ListNode sum_node = new ListNode(list_num);
            tail.next = sum_node;
            tail = tail.next;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
        }
        return dummy.next;
    }
}
