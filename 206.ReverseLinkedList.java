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
  public ListNode reverseList(ListNode head) {
    // initialize prev and curr
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;

    while (curr != null) {
      // point curr next to next  
      next = curr.next;

      // next node will be prev -> reversing the linked list
      curr.next = prev;

      // prev will be pointing to current 
      prev = curr;

      // 
      curr = tempNext; 
    } 

    return prev;
  }
}