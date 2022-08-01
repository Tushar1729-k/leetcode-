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
  public boolean isPalindrome(ListNode head) {

    if (head.next == null)
      return true;
    // copy into array! :/
    List<Integer> valsList = new ArrayList<>();
    int len = 0;
    for (ListNode tmp = head; tmp != null; tmp = tmp.next, len++)
      valsList.add(tmp.val);
    // split from mid
    int l = len/2-1;
    int r = len %2 == 0 ? len/2 : len/2+1;
    while (l >= 0 && r < len && valsList.get(l) == valsList.get(r)) {
      l--; r++;
    }
    if (l == -1 && r == len)
      return true;
    return false;
  }
}
