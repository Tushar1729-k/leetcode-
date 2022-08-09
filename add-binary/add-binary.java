class Solution {
  
  public static String addBinary(String a, String b) {

    int aLen = a.length(); int bLen = b.length();
    int longerLen = aLen > bLen ? aLen : bLen;
    int shorterLen = longerLen == aLen ? bLen : aLen;
    String longer = longerLen == aLen ? a : b;
    String shorter = longer == a ? b : a;
    int longerI = longerLen-1;
    int shorterI = shorterLen-1;
    boolean carryOne = false;
    StringBuilder sb = new StringBuilder();
    while (shorterI >= 0 && longerI >= shorterI) {
      int shorterDigit = Integer.parseInt(shorter.charAt(shorterI)+"");
      int longerDigit = Integer.parseInt((longer.charAt(longerI))+"");
      int digitSum = shorterDigit + longerDigit;
      if (carryOne) digitSum++;
      carryOne = digitSum > 1 ? true : false;
      if (carryOne)
        sb.insert(0, digitSum-2);
      else
        sb.insert(0, digitSum);
      shorterI--;
      longerI--;
    }
    while (longerI >= 0) {
      int digitSum = Integer.parseInt(longer.charAt(longerI)+"");
      if (carryOne)
        digitSum++;
      carryOne = digitSum > 1 ? true : false;
      if (carryOne)
        sb.insert(0, '0');
      else
        sb.insert(0, digitSum);
      longerI--;
    }
    if (carryOne)
      sb.insert(0, '1');

    return sb.toString();
  }
}