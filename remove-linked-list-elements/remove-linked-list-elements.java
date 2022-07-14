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
  public ListNode removeElements(ListNode head, int val) {

    if (head == null)
      return null;
    if (val == 0)
      return head;
    ListNode slowPtr = new ListNode();
    slowPtr.next = head;
    while (slowPtr.next != null) {
      if (slowPtr.next.val == val) {
        ListNode nextNode = slowPtr.next;
        while (nextNode != null && nextNode.val == val)
          nextNode = nextNode.next;
        slowPtr.next = nextNode;
        if (slowPtr.val == 0)
          head = slowPtr.next;
        if (slowPtr.next == null)
          return head;
      }
      slowPtr = slowPtr.next;
    }
    return head;
  }
}