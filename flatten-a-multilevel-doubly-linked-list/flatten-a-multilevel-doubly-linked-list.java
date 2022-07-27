/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
  public Node flatten(Node head) {
    if (head == null)
      return head;
    recFlatten(head);
    return head;
  }
  private Node recFlatten(Node head) {
    
    Node tmp = head;
    // check if were at the end of A (child) list
    while (tmp != null && tmp.next != null || (tmp == head && head.next == null)) {
      // check child node
      if (tmp.child != null) {
        Node tmpChildEnd = recFlatten(tmp.child);
        tmpChildEnd.next = tmp.next;
        if (tmp.next != null)
          tmp.next.prev = tmpChildEnd;
        tmp.next = tmp.child;
        tmp.child.prev = tmp;
        tmp.child = null;
      }
      else 
        tmp = tmp.next;
    }
    if (tmp == null)
      return head;
    return tmp;
  }
}