class Solution {
  public void reverseString(char[] s) {

    int ptrLeft = 0; int ptrRight = s.length-1;
    while (ptrLeft != ptrRight && ptrLeft < ptrRight) {
      // swap
      char tmp = s[ptrLeft];
      s[ptrLeft] = s[ptrRight];
      s[ptrRight] = tmp;
      ptrLeft++;
      ptrRight--;
    }
  }
}