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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = find_length(head);
        int start_position = length - n - 1;
        if(start_position < 0) {
            return head.next;
        }
        System.out.println("start_position " + start_position);
        int count = 0;
        ListNode curr = head;
        while(null != curr && count < start_position) {
            count++;
            curr = curr.next;
        }
        ListNode nextNode = curr.next;
        curr.next = nextNode.next;
        return head;
    }

    private int find_length(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        int sp_count = 1;
        while(null != fp && null != fp.next && null != fp.next.next) {
            sp_count++;
            sp = sp.next;
            fp = fp.next.next;
        }
        return null != fp && null == fp.next ? 2 * sp_count - 1 : 2 * sp_count;
    }
}
