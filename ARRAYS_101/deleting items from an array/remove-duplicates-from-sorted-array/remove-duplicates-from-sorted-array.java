class Solution {
  public int removeDuplicates(int[] nums) {

    int totalNumElems = nums.length;
    int numDupes = 0;
    int posOfLastElem = nums.length;
    int totalNumDupes = 0;
    int curElem = nums[0];
    int numsLeft = nums.length;
    boolean isSameElem = true;
    int i = 1;
    while (i < posOfLastElem) {
      if (nums[i] == curElem) {
        numDupes++;
        numsLeft--;
        i++;
      }
      else {
        curElem = nums[i];
        // shift down by numDupes
        for (int j = i; j < posOfLastElem; j++)
          nums[j-numDupes] = nums[j];
        i = i - numDupes + 1;
        posOfLastElem -= numDupes;
        totalNumDupes += numDupes;
        numDupes = 0;
      }
    }
    return numsLeft;
  }
}