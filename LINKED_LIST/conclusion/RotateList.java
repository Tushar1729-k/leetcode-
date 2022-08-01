package conclusion;

import ListNode.ListNode;
import singly_linked_list.design_linked_list.MySinglyLL;

public class RotateList {
  
  public static void main(String[] args) {
    
    MySinglyLL ll = new MySinglyLL();
    ll.addAtHead(78);
    ll.addAtTail(98);
    ll.addAtTail(40);
    ll.addAtTail(23);
    ll.addAtTail(25);
    ll.addAtTail(26);
    ll.addAtTail(49);
    ll.addAtTail(45);
    int k = 14;
    ListNode head = ll.getHead();
    rotateRight(head, k);
    ll.print();
  }

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
