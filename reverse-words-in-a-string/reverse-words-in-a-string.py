class Solution:
  def reverseWords(self, s: str) -> str:
    s = s.strip()
    i = 0
    insertPos = len(s)
    word = ''
    offset = 0
    while i < len(s):
      if s[i] == ' ':
        if len(word) == insertPos:
          # WERE DONEEEEE
          return s
        word = ' ' + word
        s = s[:insertPos] + word + s[insertPos:]
        s = s[len(word):]
        s = s.lstrip()
        insertPos = len(s)
        offset += len(word)
        insertPos -= offset
        i = 0
        word = ''
      word += s[i]
      i += 1
    
    return s
  