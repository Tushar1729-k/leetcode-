package singly_linked_list.design_linked_list;

import ListNode.ListNode;

public class MySinglyLL {

    private int size;
    private ListNode head;
    private ListNode tail;
  
    public MySinglyLL() {
      size = 0;
      head = null;
      tail = null;
    }
    
    public ListNode getHead() {
      return head;
    }

    public int get(int index) {
      if (index >= size || index < 0)
        return -1;
      if (index == 0)
        return head.val;
      if (index == size-1)
        return tail.val;
      ListNode tmp = head;
      for (int i = 0; i < index; i++)
        tmp = tmp.next;
      return tmp.val;
    }
    
    public void addAtHead(int val) {
      ListNode newHead = new ListNode(val);
      newHead.next = head;
      if (head == null)
        tail = newHead;
      head = newHead;
      size++;
    }
    
    public void addAtTail(int val) {
      ListNode newTail = new ListNode(val);
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
      ListNode newNode = new ListNode(val);
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
      ListNode tmp = head;
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
      ListNode tmp = head;
      for (int i = 0; i < index-1; i++)
        tmp = tmp.next;
      tmp.next = tmp.next.next;
      if (tmp.next == null)
        tail = tmp;
      size--;
    }
  
    public void print() {
      ListNode tmp = head;
      while (tmp != null && tmp.next != null) {
        System.out.print(tmp.val + " -> ");
        tmp = tmp.next;
      }
      if (tmp != null)
        System.out.println(tmp.val);
      else {
        System.out.println("Empty LL");
        System.out.println("size="+size);
        return;
      }
      System.out.println("size="+size);
      // System.out.print(tmp.val);
      // tmp = head.next;
      // printRec(tmp);
      // System.out.println();
    }

    private void printRec(ListNode head) {
      if (head == null || head.next == null)
        return;
      printRec(head.next);
      System.out.print(" -> " + head.val);
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