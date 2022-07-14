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

    ListNode slowPtr = head;
    ListNode fastPtr = head;
    // give fast an n node head start
    for (int i = 0; i < n; i++) 
      fastPtr = fastPtr.next;
    // remove head itself
    if (fastPtr == null)
      return head.next;
    while (fastPtr.next != null) {
      fastPtr = fastPtr.next;
      slowPtr = slowPtr.next;
    }
    assert(fastPtr.next == null);
    // skip over next node from slowptr
    slowPtr.next = slowPtr.next.next;
    return head;
  }
}