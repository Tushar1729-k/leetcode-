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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
    int i = 0;
    ListNode l1Tmp = l1;
    ListNode l2Tmp = l2;
    ListNode lSum = null;
    ListNode lSumTmp = lSum;
    boolean carry = false;
    while (l1Tmp != null || l2Tmp != null) {
      ListNode lSumDigit = null;
      if (l1Tmp != null && l2Tmp != null) {
        int sum = l1Tmp.val + l2Tmp.val;
        if (carry) sum++;
        carry = sum > 9 ? true : false;
        if (carry) sum -= 10;
        lSumDigit = new ListNode(sum);
        l1Tmp = l1Tmp.next;
        l2Tmp = l2Tmp.next;
      }
      else if (l1Tmp == null) {
        int sum = l2Tmp.val;
        if (carry) sum++;
        carry = sum > 9 ? true : false;
        if (carry) sum-=10;
        lSumDigit = new ListNode(sum);
        l2Tmp = l2Tmp.next;
      }
      else if (l2Tmp == null) {
        int sum = l1Tmp.val;
        if (carry) sum++;
        carry = sum > 9 ? true : false;
        if (carry) sum-=10;
        lSumDigit = new ListNode(sum);
        l1Tmp = l1Tmp.next;
      }
      if (lSumTmp == null) {
        lSum = lSumDigit;
        lSumTmp = lSum;
      }
      else {
        lSumTmp.next = lSumDigit;
        lSumTmp = lSumTmp.next;
      }
    }
    if (carry)
      lSumTmp.next = new ListNode(1);
    
    return lSum;
  }
}