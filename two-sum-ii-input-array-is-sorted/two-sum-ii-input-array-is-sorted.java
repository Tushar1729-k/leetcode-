class Solution {
  public int[] twoSum(int[] numbers, int target) {

    int compl = 0;
    int[] indices = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      compl = target - numbers[i];
      int complIndex = Arrays.binarySearch(numbers, compl);
      if (complIndex >= 0) {
        if (complIndex == i)
          complIndex++;
        return new int[]{i+1,complIndex+1};
      }
    }
    
    return new int[]{1,2};
  }
}