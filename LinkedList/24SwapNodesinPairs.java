/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while(prev != null) {
            prev = swap(prev);
        }

        return dummy.next;
    }

    // swap the curr and next, then concatenate the two nodes into the original list
    private ListNode swap(ListNode prev) {

        if(prev.next == null || prev.next.next == null) {
            return null;
        }
        ListNode curr = prev.next;
        ListNode next = curr.next;
        ListNode temp = next.next;

        prev.next = next;
        next.next = curr;
        curr.next = temp;

        return curr;
    }

}
