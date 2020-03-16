/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // find the beginning and end point of the area that should be reversed.
        ListNode beginBefore = null;   //m-1 node
        ListNode begin = null;         //mth node
        ListNode end = null;           //nth node
        ListNode endAfter = null;      //n+1th node

        ListNode curr = dummy;         // be careful about m-1 and dummy!
        for(int i = 0; i < n; i++) {
            if(i == m-1) {
                beginBefore = curr;
                begin = curr.next;
            }
            curr = curr.next;
        }
        end = curr;
        endAfter = curr.next;


        // reverse the list from begin to end
        curr = begin;
        ListNode prev = null;
        while(curr!= endAfter) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // concatenate the part before m, m to n, part after n
        beginBefore.next = end;
        begin.next = endAfter;

        return dummy.next;
    }
}
