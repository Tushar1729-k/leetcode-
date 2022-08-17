class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {

    List<Integer> nums1List = new ArrayList<>();
    for (int num1 : nums1)
      nums1List.add(num1);
    List<Integer> nums2List = new ArrayList<>();
    for (int num2 : nums2)
      nums2List.add(num2);
    Set<Integer> nums1Set = new HashSet<>(nums1List);
    Set<Integer> nums2Set = new HashSet<>(nums2List);
    List<Integer> intersection = new ArrayList<>();
    for (Integer num1 : nums1Set) {
      if (nums2Set.contains(num1))
        intersection.add(num1);
    }
  
    Integer[] intersect = intersection.toArray(new Integer[0]);
    int[] intersectArr = new int[intersection.size()];
    for (int i = 0; i < intersection.size(); i++)
      intersectArr[i] = intersect[i];
    return intersectArr;
  }
}