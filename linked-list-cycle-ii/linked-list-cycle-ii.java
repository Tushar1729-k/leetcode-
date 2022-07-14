/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {

    ListNode slowPtr = head;
    if (slowPtr == null)
      return null;
    ListNode fastPtr = head;
    // fastPtr goes by two if catches up to slow then return node
    while (fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
      fastPtr = fastPtr.next;
      if (slowPtr == fastPtr) {
        // reset slow to head and move both one at a time
        slowPtr = head;
        while (slowPtr != fastPtr) {
          slowPtr = slowPtr.next;
          fastPtr = fastPtr.next;
        }
        return slowPtr;
      }
    }
    
    return null;
  }
}