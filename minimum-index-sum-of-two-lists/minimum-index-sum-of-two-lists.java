class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
      // Map<Integer, Integer> list1MapToPos = new HashMap<>();
      // for (int i = 0; i < list1.length; i++)
      //   list1MapToPos.put(list1[i], i);
      Map<String, Integer> list2MapToPos = new HashMap<>();
      for (int i = 0; i < list2.length; i++)
        list2MapToPos.put(list2[i], i);
      
      List<String> common = new ArrayList<>();
      int minIndexSum = Integer.MAX_VALUE;
      for (int i = 0; i < list1.length; i++) {
        int indexSum = i;
        Integer matchPos = list2MapToPos.get(list1[i]);
        if (matchPos != null) {
          indexSum += matchPos;
          if (indexSum < minIndexSum) {
            if (!common.isEmpty())
              common.remove(0);
            common.add(0, list1[i]);
            minIndexSum = indexSum;
          }
          else if (indexSum == minIndexSum)
            common.add(list1[i]);
        }
      }
      return common.toArray(new String[0]);
    }
}