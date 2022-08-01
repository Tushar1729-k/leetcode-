class Solution {
  public int[] replaceElements(int[] arr) {

    int i = arr.length-1;
    int origNextElem = arr[arr.length-1];
    arr[arr.length-1] = -1;
    i--;
    while (i >= 0) {
      int curElem = arr[i];
      arr[i] = origNextElem;
      origNextElem = curElem > origNextElem ? curElem : origNextElem;
      i--;
    }
    return arr;
  }
}
