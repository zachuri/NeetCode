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
    if (head == null && head.next == null) {
      return;
    }

    // Find the middle of the linked list
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Reverse the the second half of the linked list

    ListNode prev = null;
    ListNode curr = slow;
    ListNode next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    // Merge the fist and second half

    ListNode firstHalf = head;
    ListNode secondHalf = prev;

    while (secondHalf.next != null) {
      ListNode temp = firstHalf.next;
      firstHalf.next = secondHalf;
      firstHalf = temp;

      temp = secondHalf.next;
      secondHalf.next = firstHalf;
      secondHalf = temp;
    }
  }
}