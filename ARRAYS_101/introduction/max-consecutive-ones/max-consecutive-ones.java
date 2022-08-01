class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    
    int maxConsecOnes = 0;
    int consecOnes = 0;
    boolean consec = true;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        consec = false;
        consecOnes = 0;
      }
      else if (nums[i] == 1) {
        consec = true;
        consecOnes++;
      }
      if (consecOnes > maxConsecOnes)
        maxConsecOnes = consecOnes;
    }
    return maxConsecOnes;
  }
}