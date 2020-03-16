/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class IterativeSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val)  {
                ListNode temp = l1.next;
                curr.next = l1;
                l1 = temp;
            } else {
                ListNode temp = l2.next;
                curr.next = l2;
                l2 = temp;
            }
            curr = curr.next;
        }

        // Exactly one linked list can be null.
        // We have to connect the remained ListNode to the end of the merged list.
        curr.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}
