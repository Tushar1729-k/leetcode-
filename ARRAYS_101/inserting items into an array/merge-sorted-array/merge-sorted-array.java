class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int nums1Pos = 0;
    int nums2Pos = 0;
    int[] mergedArr = new int[m + n];
    int mergedArrPos = 0;
    while (nums1Pos < m && nums2Pos < n) {
      if (nums1[nums1Pos] <= nums2[nums2Pos]) {
        mergedArr[mergedArrPos] = nums1[nums1Pos];
        nums1Pos++;
        mergedArrPos++;
      }
      else {
        // shift everything right one
        // for (int i = nums1.length-1; i > mergedArrPos; i--)
        //   nums1[i] = nums1[i-1];
        mergedArr[mergedArrPos] = nums2[nums2Pos];
        mergedArrPos++;
        nums2Pos++;
      }
    }
    // if (nums1Pos < nums1.length-1)
    //   nums1Pos++;
    // if (nums1[mergedArrPos] != 0 && mergedArrPos < nums1.length - 1)
    //   mergedArrPos++;
    // reached end of either m or n
    while (nums1Pos < m) {
      mergedArr[mergedArrPos] = nums1[nums1Pos];
      mergedArrPos++;
      nums1Pos++;
    }
    while (nums2Pos < n) {
      mergedArr[mergedArrPos] = nums2[nums2Pos];
      mergedArrPos++;
      nums2Pos++;
    }
    // transfer mergedArr to nums1
    for (int i = 0; i < nums1.length; i++)
      nums1[i] = mergedArr[i];
    
  }
}