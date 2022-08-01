package doubly_linked_list;

public class MyDoublyLL {

  int size;
  Node head;

  public MyDoublyLL() {
    size = 0;
    head = null;
  }
  
  public int get(int index) {
    if (index >= size || index < 0)
      return -1;
    if (index == 0)
      return head.val;
    if (index == size-1)
      return head.prev.val;
    if (index < size/2 || (size%2==1 && index==size/2)) {
      Node forwardTmp = head;
      for (int i = 0; i < index; i++)
        forwardTmp = forwardTmp.next;
      return forwardTmp.val;
    }
    else {
      Node backwardTmp = head.prev;
      for (int i = size-1; i > index; i--) {
        if (i == 36)
          System.out.print("");
        backwardTmp = backwardTmp.prev;
      }
      return backwardTmp.val;
    }
  }
  
  public void addAtHead(int val) {
    Node newHead = new Node(val);
    newHead.next = head;
    if (head != null) {
      newHead.prev = head.prev;
      head.prev.next = newHead;
      head.prev = newHead;
    }
    head = newHead;
    size++;
  }
  
  public void addAtTail(int val) {
    Node newTail = new Node(val);
    newTail.next = head;
    if (head != null) {
      newTail.prev = head.prev;
      // no tail before
      if (head.prev == null) {
        newTail.prev = head;
        head.next = newTail;
      }
      if (head.prev != null)
        head.prev.next = newTail;
      head.prev = newTail;
    }
    else
      head = newTail;
    size++;
  }
  
  public void addAtIndex(int index, int val) {
    Node newNode = new Node(val);
    if (index == 0) {
      addAtHead(val);
      return;
    }
    if (index == size) {
      addAtTail(val);
      return;
    }
    if (index > size)
      return;
    if (index < size/2 || (size%2==1 && index==size/2)) {
      Node forwardTmp = head;
      for (int i = 0; i < index-1; forwardTmp = forwardTmp.next)
        i++;
      newNode.next = forwardTmp.next;
      if (forwardTmp.next != null)
        forwardTmp.next.prev = newNode;
      newNode.prev = forwardTmp;
      forwardTmp.next = newNode;
    }
    else {
      Node backwardTmp = head.prev;
      for (int i = size-1; i > index; i--)
        backwardTmp = backwardTmp.prev;
      newNode.prev = backwardTmp.prev;
      if (backwardTmp.prev != null)
        backwardTmp.prev.next = newNode;
      newNode.next = backwardTmp;
      backwardTmp.prev = newNode;
    }
    size++;
  }
  
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size)
      return;
    // removeHead
    if (index == 0) {
      if (head == null)
        return;
      head.prev.next = head.next;
      head.next.prev = head.prev;
      head = head.next;
      size--;
      return;
    } 
    // removeTail
    else if (index == size-1) {
      head.prev = head.prev.prev;
      head.prev.next = head;
      size--;
      return;
    }
    if (index < size/2 || (size%2==1 && index==size/2)) {
      Node forwardTmp = head;
      for (int i = 0; i < index-1; i++)
        forwardTmp = forwardTmp.next;
      forwardTmp.next = forwardTmp.next.next;
      forwardTmp.next.prev = forwardTmp;
    }
    else {
      Node backwardTmp = head.prev;
      for (int i = size-1; i > index+1; i--)
        backwardTmp = backwardTmp.prev;
      backwardTmp.prev = backwardTmp.prev.prev;
      backwardTmp.prev.next = backwardTmp;
    }
    size--;
  }

  private class Node {
    int val;
    Node next;
    Node prev;
    Node(int x) { val = x; }
  }

  public void print() {

    Node tmp = head;
    if (tmp == null) {
      System.out.println("Empty LL");
      System.out.println("size="+size);
      return;
    }
    System.out.print(tmp.val);
    tmp = tmp.next;
    while (tmp != null && tmp != head) {
      System.out.print(" -> " + tmp.val);
      tmp = tmp.next;
    }
    // if (tmp != null && tmp.next == head)
    //   System.out.println(tmp.val);
    System.out.println();
    System.out.println("size="+size);
    // now backwards!
    tmp = head.prev;
    if (tmp == null) { 
      System.out.println(head.val);
      return;
    }
    System.out.print(tmp.val);
    tmp = tmp.prev;
    while (tmp != null && tmp != head) {
      System.out.print(" -> " + tmp.val);
      tmp = tmp.prev;
    }
    System.out.println();
  }

}
