class Solution {
    public boolean isIsomorphic(String s, String t) {

    if (s.length() != t.length())
      return false;
    
    Map<Character, Character> charToChar = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      Character mappedTChar = charToChar.get(sChar);
      char newTChar = t.charAt(i);
      if (mappedTChar != null && mappedTChar != newTChar)
        return false;
      else {
        boolean isMappedTo = charToChar.containsValue(newTChar);
        if (isMappedTo) 
          for (Character key : charToChar.keySet())
            if (charToChar.get(key) == newTChar && key != sChar)
              return false;
        charToChar.put(s.charAt(i), newTChar);
      }
    }
    return true;
  }
}