class Solution {
  public String longestCommonPrefix(String[] strs) {

    StringBuilder sb = new StringBuilder();
    boolean same = true;
    int l = 0;
    while (same) {
      if (l >= strs[0].length())
        return sb.toString();
      char letter = strs[0].charAt(l);
      for (int i = 1; i < strs.length; i++) {
        if (l >= strs[i].length())
          return sb.toString();
        same = same && letter == strs[i].charAt(l);
      }
      if (same)
        sb.append(letter);
      l++;
    }
    
    return sb.toString();
  }
}