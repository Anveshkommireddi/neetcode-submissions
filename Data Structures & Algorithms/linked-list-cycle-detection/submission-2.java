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
    public boolean hasCycle(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        while(null != sp && null != fp && null != fp.next) {
            sp = sp.next;
            fp = fp.next.next;
            if(sp == fp) return true;
        }
        return false;
    }
}
