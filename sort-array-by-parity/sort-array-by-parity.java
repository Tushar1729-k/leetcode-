class Solution {
  public int[] sortArrayByParity(int[] nums) {

    // swap
    int i = 0;
    while (i < nums.length-1) {
      // keep swappin till hit 
      int j = i;
      boolean diff = false;
      while (j < nums.length-1 && nums[j]%2==1 && nums[j+1]%2==0) {
        diff = true;
        int tmp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = tmp;
        j++;
      }
      // swap next
      i = j;
      boolean same = false;
      if (j < nums.length-1 && nums[j]%2==1 && nums[j+1]%2==1) {
        same = true;
        // get k to end of zero consec
        int k = j;
        while (k < nums.length-1 && nums[k+1]%2==1)
          k++;
        if (k == nums.length)
          return nums;
        for (int a = k; a >= j; a--) {
          k = a;
          while (k < nums.length-1 && nums[k]%2==1 && nums[k+1]%2==0) {
            int tmp = nums[k];
            nums[k] = nums[k+1];
            nums[k+1] = tmp;
            k++;
          }
        }
      }
      i++;
    }
    return nums;
  }
}