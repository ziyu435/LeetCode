/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {

    /**
     * @param head a listnode
     * @param k an integer
     * return a ListNode
     */

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while(prev != null) {
            prev = reverseNextKNodes(prev, k);
        }

        return dummy.next;
    }



    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 ... n1 -> nk+1

    private static ListNode reverseNextKNodes(ListNode head, int k) {

        // find the kth node
        ListNode curr = head;
        ListNode n1 = head.next;

        for(int i = 0; i < k; i++) {
            curr = curr.next;
            if(curr == null) {
                return null;  // if the left-out nodes < k nodes, then do not reverse, remain as the same.
            }
        }

        ListNode nk = curr;
        ListNode nkplus = curr.next;


        // reverse the k nodes
        curr = head.next;
        ListNode prev = head;

        while(curr != nkplus) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }


        // head -> n1   nk -> n1         curr=nk, prev=nk-1
        // =>
        // head -> nk ... -> n1 -> nk+1
        head.next = nk;
        n1.next = nkplus;

        return n1;
    }


}
