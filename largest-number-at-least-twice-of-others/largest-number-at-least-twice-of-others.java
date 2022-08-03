class Solution {
  public int dominantIndex(int[] nums) {

    int max = -1;
    int maxIndex = -1;
    int secondMax = -1;
    for (int i = 0; i < nums.length; i++) {
      
      if (nums[i] > max) {
        secondMax = max;
        max = nums[i];
        maxIndex = i;
      }
      else if (nums[i] > secondMax)
        secondMax = nums[i];
    }
    if (max >= 2*secondMax)
      return maxIndex;
    return -1;
  }
}