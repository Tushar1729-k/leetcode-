class Solution {
  public boolean checkIfExist(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
      int isDouble = arr[i] * 2;
      double isHalf = arr[i] / 2.0;
      System.out.println(isHalf);
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] == isDouble || arr[j] == isHalf)
          return true;
      }
    }
    return false;
  }
}