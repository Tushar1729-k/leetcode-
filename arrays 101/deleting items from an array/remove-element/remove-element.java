class Solution {
  public int removeElement(int[] nums, int val) {

    int numsPos = 0;
    int numsLeft = nums.length;
    int numRemovals = 0;
    while (numsPos < nums.length) {
      // shift everything numsPos down left one
      if (nums[numsPos] == val) {
        numsLeft--;
        numRemovals++;
        for (int i = numsPos+1; i < nums.length; i++)
          nums[i-1] = nums[i];
        for (int i = nums.length - numRemovals; i < nums.length; i++)
          nums[i] = -1;
      }
      else
        numsPos++;
    }
    return numsLeft;
  }
}