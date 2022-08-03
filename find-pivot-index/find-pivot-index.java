class Solution {
  public int pivotIndex(int[] nums) {
    int pivotIndex = 0;
    while (pivotIndex < nums.length) {
      int leftSum = 0;
      for (int l = 0; l < pivotIndex; l++)
        leftSum += nums[l];
      int rightSum = 0;
      for (int r = pivotIndex+1; r < nums.length; r++)
        rightSum += nums[r];
      if (leftSum == rightSum)
        return pivotIndex;
      pivotIndex++;
    }
    return -1;
  }
}