import ListNode.ListNode;

class Solution {
  public ListNode oddEvenList(ListNode head) {

    if (head == null)
      return null;
    ListNode oddHead = head;
    ListNode evenHead = head.next;
    ListNode oddTmp = oddHead;
    ListNode evenTmp = evenHead;
    // evenhead should always be ahead
    while (evenTmp != null && evenTmp.next != null) {
      oddTmp.next = evenTmp.next;
      oddTmp = oddTmp.next;
      evenTmp.next = oddTmp.next;
      evenTmp = evenTmp.next;
    }
    oddTmp.next = evenHead;
    
    return oddHead;
  }
}