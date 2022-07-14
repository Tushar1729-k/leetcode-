class Solution {
  public boolean validMountainArray(int[] arr) {

    if (arr.length < 3)
      return false;
    // if its up then its stuck!
    boolean inc = false;
    boolean dec = false;
    int prevElem = arr[0];
    int i = 1;
    while (i < arr.length) {
      if (dec && arr[i] >= prevElem)
        return false;
      else if (arr[i] == prevElem)
        return false;
      else if (arr[i] > prevElem) {
        inc = true;
        prevElem = arr[i];
      }
      else if (inc && dec && arr[i] >= prevElem)
        return false;
      else if (arr[i] < prevElem) {
        dec = true;
        prevElem = arr[i];
      }
      i++;
    }
    return inc && dec;
  }
}