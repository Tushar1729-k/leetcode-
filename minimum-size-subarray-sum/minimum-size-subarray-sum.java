class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    
    int minLen = nums.length+1;
    List<Integer> window = new ArrayList<>();
    int l = 0;
    int r = 0;
    window.add(nums[r]);
    int windowSum = nums[r];
    while (r <= nums.length && l < nums.length) {
      if (windowSum >= target) {
        if (window.size() < minLen)
          minLen = window.size();
        if (minLen == 1)
          return minLen;
      }
      else if (window.size() == nums.length)
        return 0;
      if (windowSum >= target) {
        windowSum -= window.remove(0);
        l++;
        if (r == nums.length-1 && windowSum < target)
          return minLen;
      }
      if (windowSum < target) {
        if (r < nums.length-1) {
          r++;
          window.add(nums[r]);
          windowSum += nums[r];
        }
        else
          return minLen;
      }
    }
    
    return minLen == nums.length+1 ? 0 : minLen;
  }
}