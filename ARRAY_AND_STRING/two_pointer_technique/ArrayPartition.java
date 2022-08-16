package ARRAY_AND_STRING.two_pointer_technique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayPartition {

  public static void main(String[] args) {
    
    int[] nums = 
                // {1,4,3,2};
                {6,2,6,5,1,2};
                // {7,3,1,0,0,6};
    
    System.out.println(arrayPairSum(nums));
  }

  public static int arrayPairSum(int[] nums) {

    int maxSum = Integer.MIN_VALUE;
    int l = 0;
    int r = 1;
    int n = nums.length/2;
    while (r != nums.length) {
      int pairs = 0;
      List<Set<Integer>> group=new ArrayList<Set<Integer>>();
      int sum = 0;
      List<Integer> oldLIs = new ArrayList<>(); oldLIs.add(l);
      List<Integer> oldRIs = new ArrayList<>();
      int tmpL = l;
      int tmpR = r;
      while (pairs < n) {
        Set<Integer> pair = new HashSet<>();
        pair.add(nums[tmpL]); pair.add(nums[tmpR]);
        sum += Collections.min(pair);
        group.add(pair);
        pairs++;
        if (pairs == n)
          break;
        oldRIs.add(tmpR);
        while (oldLIs.contains(tmpL) || oldRIs.contains(tmpL))
          tmpL++;
        oldLIs.add(tmpL);
        boolean backwards = false;
        int backSum = 0;
        int backSumPos = -1;
        List<Integer> backRIs = new ArrayList<>();
        do {
          int backSumCur = 0;
          int backSumCurPos = -1;
          boolean tmpRChanged = false;
          while (oldLIs.contains(tmpR) || oldRIs.contains(tmpR) || !tmpRChanged) {
            if (tmpR == nums.length-1)
              backwards = true;
            while (backwards && (backRIs.contains(tmpR) || oldRIs.contains(tmpR))) {
              tmpR--;
              tmpRChanged = true;
            }
            backRIs.add(tmpR);
            backSumCurPos = tmpR;
            if (!backwards) {
              tmpR++;
              tmpRChanged = true;
            }
          }
          backSumCur += nums[tmpL] + nums[tmpR];
          if (backSumCur > backSum) {
            backSum = backSumCur;
            backSumPos = backSumCurPos;
          }
        } while (backwards && tmpR >= nums.length/2 && tmpR != tmpL+1);
        if (backwards)
          tmpR = backSumPos;
      }
      if (sum > maxSum)
        maxSum = sum;
      r++;
    }
    return maxSum;
  }
}