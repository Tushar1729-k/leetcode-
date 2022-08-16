package ARRAY_AND_STRING.two_pointer_technique;

import java.util.ArrayList;
import java.util.List;

public class MinSizeSubarray {
  
  public static void main(String[] args) {
    
    int target = 
                // 7;
                // 4;
                // 11;
                // 11;
                // 15;
                213;
    int[] nums = 
                // {2,3,1,2,4,3};
                // {1,4,4};
                // {1,1,1,1,1,1,1,1};
                // {1,2,3,4,5};
                // {1,2,3,4,5};
                {12,28,83,4,25,26,25,2,25,25,25,12};
    System.out.println(minSubArrayLen(target, nums));
  }

  public static int minSubArrayLen(int target, int[] nums) {
    
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
