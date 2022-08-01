package conclusion;

public class FlattenLL {
  // Definition for a Node.
  private static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int val) {
      this.val = val;
      child = null;
    }
  };
  private Node head;
  public FlattenLL(){head=null;}
  // public print() {
  // }
  public static void main(String[] args) {
    FlattenLL multiLL = new FlattenLL();
    Node head = new Node(1);
    multiLL.head = head;
    head.next = new Node(2);
    head.next.prev = head;
    head.next.next = new Node(3);
    head.next.next.prev = head.next;
    head.next.next.child = new Node(7);
    head.next.next.next = new Node(4);
    head.next.next.next.prev = head.next.next;
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.prev = head.next.next.next;
    head.next.next.next.next.next = new Node(6);
    head.next.next.next.next.next.prev = head.next.next.next.next;
    head.next.next.child.next = new Node(8);
    head.next.next.child.next.prev = head.next.next.child;
    head.next.next.child.next.child = new Node(11);
    head.next.next.child.next.child.next = new Node(12);
    head.next.next.child.next.child.next.prev = head.next.next.child.next.child;
    head.next.next.child.next.next = new Node(9);
    head.next.next.child.next.next.prev = head.next.next.child.next;
    head.next.next.child.next.next.next = new Node (10);
    head.next.next.child.next.next.next.prev = head.next.next.child.next.next.prev;
    flatten(multiLL.head);
  }

  public static Node flatten(Node head) {
    recFlatten(head);
    return head;
  }
  private static Node recFlatten(Node head) {
    Node tmp = head;
    // check if were at the end of A (child) list
    while (tmp.next != null) {
      // check child node
      if (tmp.child != null) {
        Node tmpChildEnd = flatten(tmp.child);
        tmpChildEnd.next = tmp.next;
        tmp.next.prev = tmpChildEnd;
        tmp.next = tmp.child;
        tmp.child.prev = tmp;
        tmp.child = null;
      }
      else
        tmp = tmp.next;
    }
    return tmp;
  }
}
