class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {

    List<Integer> disappeared = new ArrayList<>();
    int i = 1;
    while (i <= nums.length) {
      if (nums[i-1] == i) {
        i++;
        continue;
      }
      int oldNum = nums[nums[i-1]-1];
      if (nums[oldNum-1] != oldNum)
        disappeared.add(oldNum);
      nums[nums[i-1]-1] = nums[i-1];
      i++;
    }
    System.out.println(disappeared);
    for (i = disappeared.size(); i > 0; i--) {
      if (nums[disappeared.get(i-1)-1] != disappeared.get(i-1))
        nums[disappeared.get(i-1)-1] = disappeared.get(i-1);
      disappeared.remove((int)(disappeared.size()-1));
    }
    System.out.println(Arrays.toString(nums));
    for (i = 1; i <= nums.length; i++)
      if (i != nums[i-1])
        disappeared.add(i);

    return disappeared;
  }
}