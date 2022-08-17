class Solution {
  public int firstUniqChar(String s) {

    Map<Character, Integer> charMap = new LinkedHashMap<>();
    Set<Character> nonDupeCharSet = new LinkedHashSet<>();
    for (char c : s.toCharArray())
      nonDupeCharSet.add(c);
    int i = 0;
    while (i < s.length()) {
      if (charMap.containsKey(s.charAt(i)))
        nonDupeCharSet.remove(s.charAt(i));
      charMap.put(s.charAt(i), i);
      i++;
    }
    if (!nonDupeCharSet.isEmpty())
      return charMap.get(nonDupeCharSet.iterator().next());
    return -1;
  }
}