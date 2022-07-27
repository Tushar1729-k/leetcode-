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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode l1Ptr = list1;
    ListNode l2Ptr = list2;
    ListNode l0 = null;
    Integer l1Val;
    if (l1Ptr != null)
      l1Val = l1Ptr.val;
    Integer l2Val;
    if (l2Ptr != null)
      l2Val = l2Ptr.val;
    if (l1Ptr == null || l2Ptr == null) {
      if (l1Ptr == null) {
        if (l2Ptr == null)
          return null;
        else {
          l0 = l2Ptr;
          l2Ptr = l2Ptr.next;
        }
      }
      else {
        if (l2Ptr == null) {
          l0 = l1Ptr;
          l1Ptr = l1Ptr.next;
        }
      }
    }
    // comp as normal
    else if (l1Ptr.val <= l2Ptr.val) {
      l0 = l1Ptr;
      l1Ptr = l1Ptr.next;
    }
    else {
      l0 = l2Ptr;
      l2Ptr = l2Ptr.next;
    } 
    ListNode l0Ptr = l0;
    while (l1Ptr != null && l2Ptr != null) {
      if (l1Ptr.val <= l2Ptr.val) {
        l0Ptr.next = l1Ptr;
        l0Ptr = l0Ptr.next;
        l1Ptr = l1Ptr.next;
      }
      else {
        l0Ptr.next = l2Ptr;
        l0Ptr = l0Ptr.next;
        l2Ptr = l2Ptr.next;
      } 
    }
    while (l1Ptr != null) {
      // add rest of l1
      l0Ptr.next = l1Ptr;
      l0Ptr = l0Ptr.next;
      l1Ptr = l1Ptr.next;
    }
    while (l2Ptr != null) {
      // add rest of l2
      l0Ptr.next = l2Ptr;
      l0Ptr = l0Ptr.next;
      l2Ptr = l2Ptr.next;
    }
    
    return l0;
  }
}