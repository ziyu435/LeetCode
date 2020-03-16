/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution1 {

    // Iterative
    // The original linked list won't be changed.

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = new ListNode(head.val);
        p = p.next;

        while(p != null) {
            ListNode temp = q;
            q = new ListNode(p.val);
            q.next = temp;
            p = p.next;
        }
        return q;
    }
}



public class Solution2 {

    // Iterative
    // The original list no long exists. Only the head exists.

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}



public class Solution3 {

    // Recursive
    // The original list no long exists. Only the head exists.

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

}
