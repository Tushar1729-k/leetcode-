/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {

    Node tmp = head;
    Node newHead = null;
    Node newTmp = newHead;
    Map<Node, Node> origToCopy = new HashMap<>();
    while (tmp != null) {
      
      Node newNode = null;
      if (!origToCopy.containsKey(tmp))
        newNode = new Node(tmp.val);
      else
        newNode = origToCopy.get(tmp);
      if (newTmp == null) {
        newHead = newNode;
        newTmp = newHead;
        origToCopy.put(tmp, newTmp);
      }
      else {
        newTmp.next = newNode;
        newTmp = newTmp.next;
        origToCopy.put(tmp, newTmp);
      }
      // if (tmp.next != null) {
      //   Node newNextNode = new Node(tmp.next.val);
      //   newTmp.next = newNextNode;
      // }
      if (tmp.random != null) {
        // does orig list alr contain random node?
        if (origToCopy.containsKey(tmp.random))
          newTmp.random = origToCopy.get(tmp.random);
        else {
          newTmp.random = new Node(tmp.random.val);
          origToCopy.put(tmp.random, newTmp.random);
        }
      }
      tmp = tmp.next;
    }
    return newHead;
  }
}