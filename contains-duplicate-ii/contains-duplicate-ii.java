class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {

    Map<Integer, Integer[]> numToPos = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer[] curPos = numToPos.get(nums[i]);
      int minDistFromOrig = nums.length;
      if (curPos == null)
        numToPos.put(nums[i], new Integer[]{i, minDistFromOrig});
      else {
        int curDist = i - curPos[0];
        if (curDist < curPos[1]) {
          minDistFromOrig = curDist;
          numToPos.put(nums[i],new Integer[]{i, minDistFromOrig});
        }
      }
    }
    
    for (int i = 0; i < nums.length-1; i++) {
      Integer dupePos = numToPos.get(nums[i])[0];
      if (dupePos != null && dupePos != i && Math.abs(dupePos-i) <= k)
        return true;
    }
    return false;
  }
}