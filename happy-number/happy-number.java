class Solution {
  public boolean isHappy(int n) {

    int origNum = n;
    do {
      int sumOfSqs = 0;
      int base2Log = (int)Math.log10(n);
      int numDigits = base2Log == (int)base2Log ? base2Log+1 : (int)Math.ceil(base2Log);
      for (int i = 1; i <= numDigits; i++) {
        sumOfSqs += Math.pow(n % 10, 2);
        n /= 10;
      }
      n = sumOfSqs;
    } while (n != 1 && n != 4);
    if (n == 1)
      return true;
    return false;
  }
}