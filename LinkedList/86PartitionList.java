/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode dummyLess = new ListNode(-1);
        ListNode pointerLess = dummyLess;
        ListNode dummyLarger = new ListNode(-1);
        ListNode pointerLarger = dummyLarger;

        while(head != null) {
            ListNode temp = head.next;
            head.next = null;
            if(head.val < x) {
                pointerLess.next = head;
                pointerLess = pointerLess.next;
            } else{
                pointerLarger.next = head;
                pointerLarger = pointerLarger.next;
            }
            head = temp;
        }
        pointerLess.next = dummyLarger.next;
        return dummyLess.next;
    }

}
