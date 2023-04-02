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
    // Fast and slow pointer

    ListNode slow = head;
    ListNode fast = head;


    // Have pointer ahead based on n
    for (int i = 0; i < n; ++i) {
      fast = fast.next;
    }

    if (fast == null) {
      return head.next;
    }

    // loop till fast reaches the end
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    // slow will reach the point of node before
    // we want to point this node to the node after the one we want to remove
    slow.next = slow.next.next;

    return head;
  }
}