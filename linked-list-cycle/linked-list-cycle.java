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
  public boolean hasCycle(ListNode head) {
    ListNode slowptr = head;
    if (head == null || head.next == null)
      return false;
    ListNode fastptr = head.next;
    while (fastptr != slowptr && fastptr != null && fastptr.next != null) {
      fastptr = fastptr.next.next;
      slowptr = slowptr.next;
    }
    if (fastptr == slowptr)
      return true;
    return false;
  }
}