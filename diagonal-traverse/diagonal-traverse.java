class Solution {
  public int[] findDiagonalOrder(int[][] mat) {

    // start from 00 check bounds if high limited then -1-1 else +1+1
    int[] diagOrder = new int[mat.length*mat[0].length];
    int i = 0; int j = 0;
    int diagOrderArrPos = 0;
    boolean diagRight = true;
    while (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && diagOrderArrPos < diagOrder.length) {
      
      diagOrder[diagOrderArrPos] = mat[i][j];
      if (diagRight) {
        i--; j++; }
      else {
        i++; j--; }
      boolean iReset = false;
      boolean jReset = false;
      if (i < 0) {
        i = 0;
        iReset = true;
        diagRight = false;
      }
      else if (j < 0) {
        j = 0;
        jReset = true;
        diagRight = true;
      }
      if (i >= mat.length) {
        i = mat.length-1;
        if (j == 0 && jReset)
          j++;
        else
          j += 2;
        diagRight = true;
      }
      if (j >= mat[0].length) {
        j = mat[0].length-1;
        if (i == 0 && iReset)
          i++;
        else
          i += 2;
        diagRight = false;
      }
      diagOrderArrPos++;
    }
    return diagOrder;
  }
}