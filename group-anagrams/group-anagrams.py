class Solution:
  def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    strsetToGroup = {}
    for i in range(len(strs)):
      sortedWord = tuple(sorted(strs[i]))
      group = strsetToGroup.get(sortedWord)
      if group == None:
        strsetToGroup[sortedWord] = [strs[i]]
      else:
        group.append(strs[i])
    
    return strsetToGroup.values()