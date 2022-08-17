class Solution {
  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> numToPos = new HashMap<>();
    for (int i = 0; i < nums.length-1; i++) {
      int compl = target - nums[i];
      for (int j = i+1; j < nums.length; j++) {
        if (nums[j] == compl)
          return new int[]{i,j};
      }
    }
    return new int[]{0,1};
  }
}