class Solution {
  public int thirdMax(int[] nums) {

    int[] decMaxes = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    decMaxes[0] = nums[0];
    int numMins = 1;
    boolean containsMin = false;
    if (decMaxes[0] == Integer.MIN_VALUE)
      containsMin = true;
    int i = 1;
    while (i < nums.length) {
      boolean isMin = false;
      if (!containsMin && nums[i] == Integer.MIN_VALUE) {
        containsMin = true;
        numMins++;
      }
      else if (nums[i] == Integer.MIN_VALUE)
        isMin = true;
      boolean contains = false;
      for (int j = 0; j < decMaxes.length && !contains; j++)
        if (decMaxes[j] == nums[i] && nums[i] != Integer.MIN_VALUE)
          contains = true;
      if (contains) {
        i++;
        continue;
      }
      numMins = numMins < 3 && !isMin ? numMins+1 : numMins;
      if (nums[i] > decMaxes[0]) {
        // swap slash shift down
        int j = decMaxes.length-1;
        while (j > 0) {
          decMaxes[j] = decMaxes[j-1];
          j--;
        }
        decMaxes[0] = nums[i];
      }
      else if (nums[i] > decMaxes[1]) {
        // where does it fit
        if (nums[i] > decMaxes[1]) {
          decMaxes[2] = decMaxes[1];
          decMaxes[1] = nums[i];
        }
      }
      else if (nums[i] > decMaxes[2])
        decMaxes[2] = nums[i];
      i++;
    }
    System.out.println(numMins);
    if (numMins != 3)
      return decMaxes[0];
    return decMaxes[2];
  }
}