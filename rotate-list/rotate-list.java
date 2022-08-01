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
  public static ListNode rotateRight(ListNode head, int k) {

    int size = 0;
    if (head == null || head.next == null || k == 0)
      return head;
    assert(head != null && head.next != null);
    ListNode tmp = head;
    int tmpVal = tmp.val;
    int newTmpVal = 0;
    boolean sized = false;
    boolean reduced = false;
    boolean restarted = false;
    int numRotated = 0;
    ListNode furthestRotated = head;
    while ((sized && numRotated < size) || (!sized && tmp != null)) {
      for (int i = 0; i < k; i++) {
        tmp = tmp.next;
        if (!sized)
          size++;
        if (tmp == null) {
          tmp = head;
          sized = true;
          if (k%size == 0)
            return head;
          if (k > size)
            reduced = true;
          k %= size;
        }
      }
      // restart
      if (reduced && !restarted) {
        restarted = true;
        continue;
      }
      newTmpVal = tmp.val;
      tmp.val = tmpVal;
      tmpVal = newTmpVal;
      numRotated++;
      // is node we landed on already rotated?
      // assert(head is)
      if (tmp == furthestRotated && sized && numRotated < size) {
        // we know we haven't seen tmp.next so move to it (scoot up)
        tmp = tmp.next;
        if (tmp == null)
          tmp = head;
        tmpVal = tmp.val;
        furthestRotated = tmp;
      }
    }
    return head;
  }
}