/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode tmpA = headA;
    ListNode tmpB = headB;
    while (tmpA != tmpB && tmpA.next != null && tmpB.next != null) {
      tmpA = tmpA.next;
      tmpB = tmpB.next;
    }
    if (tmpA == tmpB)
      return tmpA;
    if (tmpA.next == null) {
      int numBBehind = 0;
      while (tmpB.next != null) {
        tmpB = tmpB.next;
        numBBehind++;
      }
      if (tmpA == tmpB) {
        tmpB = headB;
        for (int i = 0; i < numBBehind; i++)
          tmpB = tmpB.next;
        tmpA = headA;
        while (tmpA != tmpB) {
          tmpA = tmpA.next;
          tmpB = tmpB.next;
        }
        assert (tmpA == tmpB);
        return tmpA;
      }
      else
        return null;
    }
    if (tmpB.next == null) {
      int numABehind = 0;
      while (tmpA.next != null) {
        tmpA = tmpA.next;
        numABehind++;
      }
      if (tmpA == tmpB) {
        tmpA = headA;
        for (int i = 0; i < numABehind; i++)
          tmpA = tmpA.next;
        tmpB = headB;
        while (tmpA != tmpB) {
          tmpA = tmpA.next;
          tmpB = tmpB.next;
        }
        assert (tmpA == tmpB);
        return tmpA;
      }
      else
        return null;
    }
    
    return null;
  }
}