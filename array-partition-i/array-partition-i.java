class Solution {
  
  public int arrayPairSum(int[] nums) {

    Arrays.sort(nums);
    int l = 0;
    int r = 1;
    int n = nums.length/2;
    int pairs = 0;
    int sum = 0;
    while (pairs < n) {
      sum += Math.min(nums[l], nums[r]);
      l += 2;
      r += 2;
      pairs++;
    }
    return sum;
  }
}