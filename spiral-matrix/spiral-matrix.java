class Solution {
  
  public static List<Integer> spiralOrder(int[][] matrix) {

    int M = matrix.length; int N = matrix[0].length;
    int newDimM = M; int newDimN = N;
    Integer[] spiralOrderArr = new Integer[M*N];
    int spiralOrderArrPos = 0;
    int i = 0; int j = 0;
    final int RIGHT = 0; final int DOWN=1; final int LEFT=2; final int UP = 3;
    final int[] dirNames = {RIGHT, DOWN, LEFT, UP};
    final int[][] dirVals = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dirPos = 0;
    int dir = dirNames[dirPos];
    int flips = 0;
    boolean flipped = false;
    spiralOrderArr[spiralOrderArrPos] = matrix[i][j];
    spiralOrderArrPos++;
    int mSum = 3;
    int nSum = 4;
    final int PERIOD = 4;
    while (0 < newDimM && 0 < newDimN && spiralOrderArrPos < spiralOrderArr.length) {
      if (matrix[i][j] == 68)
        System.out.print("");
      // check if need to flip dir!
      j += dirVals[dir][1];
      if (j == newDimN || j < N - newDimN) {
        flipped = true;
        flips++;
      }
      if (j == newDimN)
        j--;
      else if (j < N - newDimN)
        j++;
      i += dirVals[dir][0];
      if (i == newDimM || i < M - newDimM) {
        flips = flipped ? flips : flips+1;
        flipped = true;
      }
      if (i == newDimM)
        i--;
      else if (i < M - newDimM)
        i++;
      // we have a new dir!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      if (flipped) {
        if (flips % mSum == 0) {
          newDimM--;
          mSum += PERIOD;
        }
        else if (flips % nSum == 0) {
          newDimN--;
          nSum += PERIOD;
        }
        dir = dirNames[(++dirPos)%4];
        i += dirVals[dir][0];
        j += dirVals[dir][1];
        flipped = false;
      }
      spiralOrderArr[spiralOrderArrPos] = matrix[i][j];
      spiralOrderArrPos++;
    }
    return Arrays.asList(spiralOrderArr);
  }
}