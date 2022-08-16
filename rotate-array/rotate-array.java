class Solution {
  public void rotate(int[] nums, int k) {

    int rotations = 0;
    int index = 0;
    int oldVal = nums[index];
    int furthestRotatedPos = 0;
    boolean scooted = false;
    while (rotations < nums.length) {
      index = (index + k) % nums.length;
      int val = nums[index];
      nums[index] = oldVal;
      oldVal = val;
      if (index <= furthestRotatedPos) {
        index = (index+1) % nums.length;
        oldVal = nums[index];
        scooted = true;
        furthestRotatedPos++;
      }
      else
        scooted = false;
      rotations++;
    }
    
  }
}