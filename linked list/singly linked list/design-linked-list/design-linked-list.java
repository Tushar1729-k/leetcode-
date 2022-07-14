class MyLinkedList {

    int size;
    Node head;
    Node tail;
  
    public MyLinkedList() {
      size = 0;
      head = null;
      tail = null;
    }
    
    public int get(int index) {
      if (index >= size || index < 0)
        return -1;
      if (index == 0)
        return head.val;
      if (index == size-1)
        return tail.val;
      Node tmp = head;
      for (int i = 0; i < index; i++)
        tmp = tmp.next;
      return tmp.val;
    }
    
    public void addAtHead(int val) {
      Node newHead = new Node(val);
      newHead.next = head;
      if (head == null)
        tail = newHead;
      head = newHead;
      size++;
    }
    
    public void addAtTail(int val) {
      Node newTail = new Node(val);
      if (tail == null) {
        assert(head == null);
        head = newTail;
        tail = newTail;
        size++;
        return;
      }
      tail.next = newTail;
      tail = newTail;
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
      Node tmp = head;
      for (int i = 0; i < index-1; tmp = tmp.next)
        i++;
      newNode.next = tmp.next;
      tmp.next = newNode;
      size++;
    }
    
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= size)
        return;
      // removeHead
      if (index == 0) {
        if (head == tail)
          tail = head.next;
        head = head.next;
        size--;
        return;
      } 
      Node tmp = head;
      for (int i = 0; i < index-1; i++)
        tmp = tmp.next;
      tmp.next = tmp.next.next;
      if (tmp.next == null)
        tail = tmp;
      size--;
    }
  
    private class Node {
      int val;
      Node next;
      Node(int x) { val = x; }
    }
  
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */