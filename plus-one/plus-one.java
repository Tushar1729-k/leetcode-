class Solution {
  public int[] plusOne(int[] digits) {

    int i = digits.length-1;
    boolean carryOne = digits[i]+1 > 9 ? true : false;
    if (carryOne && i > 0)
      digits[i] = 0;
    while (carryOne && i > 0) {
      i--;
      carryOne = (carryOne ? digits[i]+1 : digits[i]) > 9 ? true : false;
      if (carryOne && i > 0)
        digits[i] = 0;
    }
    if (carryOne) {
      digits[i]++;
      if (digits[i] > 9) {
        digits[0] = 0;
        int[] newInt = new int[digits.length+1];
        for (int iN = newInt.length-1; iN > 0; iN--)
        newInt[iN] = digits[iN-1];
        newInt[0] = 1;
        return newInt;
      }
      return digits;
    }
    digits[i]++;
    return digits;
  }
}