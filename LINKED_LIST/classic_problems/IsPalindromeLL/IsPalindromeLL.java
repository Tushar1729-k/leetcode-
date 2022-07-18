package LINKED_LIST.classic_problems.IsPalindromeLL;

import java.util.ArrayList;
import java.util.List;

import ListNode.ListNode;

class IsPalindromeLL {

  public static void main(String[] args) {
    
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);
    // head.next.next.next.next = new ListNode(1);
    // ListNode head = new ListNode(0);
    // head.next = new ListNode(0);
    System.out.println(isPalindrome(head));
  }

  public static boolean isPalindrome(ListNode head) {

    // copy into array! :/
    List<Integer> valsList = new ArrayList<>();
    int len = 0;
    for (ListNode tmp = head; tmp != null; tmp = tmp.next, len++)
      valsList.add(tmp.val);
    // split from mid
    System.out.println(len);
    int l = len/2 - 1;
    int r = l+1;
    System.out.println(l + "," + r);
    while (l >= 0 && r < len && valsList.get(l) == valsList.get(r)) {
      l--; r++;
    }
    if (l == -1 && r == len)
      return true;
    return false;
  }
}