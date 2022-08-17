class Solution {
  public int[] twoSum(int[] nums, int target) {

    // List<Integer> numsList = Arrays.stream(int).boxed().toList();
    Map<Integer, Integer> numToPos = new HashMap<>();
    for (int i = 0; i < nums.length; i++)
      numToPos.put(nums[i], i);
    // will overwrite pos if num is duplicate
    for (int i = 0; i < nums.length-1; i++) {
      int compl = target - nums[i];
      Integer compPos = numToPos.get(compl);
      if (compPos != null && compPos != i)
        return new int[]{i,compPos};
    }
    return new int[]{0,1};
  }
}