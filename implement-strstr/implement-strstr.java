class Solution {
  public int strStr(String haystack, String needle) {

    int haystackPos = 0;
    int needlePos = 0;
    for (int i = 0; i <= haystack.length()-needle.length(); i++) {
      if (haystack.charAt(haystackPos) == needle.charAt(needlePos)) {
        int tmpHayPos = haystackPos+1;
        int tmpNeedlePos = needlePos+1;
        while (tmpHayPos < haystack.length() && tmpNeedlePos < needle.length() && haystack.charAt(tmpHayPos) == needle.charAt(tmpNeedlePos)) {
          tmpHayPos++;
          tmpNeedlePos++;
        }
        if (tmpNeedlePos == needle.length())
          return haystackPos;
      }
      
      haystackPos++;
    }
    return -1;
  }
}