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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // find middle using sp and fp 
        // reverse the list after middle 
        // using two heads we have modify the pointers
        // 1 - 2 - 3 - 4
        // 1 - 2 - 4 - 3
        ListNode middle = getMiddleNode(head);
        ListNode revHead = reverse(middle.next);
        middle.next = null;
        reOrder(head, revHead);
    }

    private void reOrder(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while(null != curr1 && null != curr2) {
            
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode fp = head;
        ListNode sp = head;
        while(null != fp && null != fp.next && null != fp.next.next) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
}