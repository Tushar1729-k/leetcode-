package ARRAY_AND_STRING.introduction_to_2d_array;

import java.util.Arrays;
import java.util.List;

class SpiralMatrix {

  public static void main(String[] args) {
    
    int[][] matrix =  
                      // {{1,2,3},{4,5,6},{7,8,9}};
                      // {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
                      // {{2,3}};
                      // {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
                      {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30},{31,32,33,34,35,36,37,38,39,40},{41,42,43,44,45,46,47,48,49,50},{51,52,53,54,55,56,57,58,59,60},{61,62,63,64,65,66,67,68,69,70},{71,72,73,74,75,76,77,78,79,80},{81,82,83,84,85,86,87,88,89,90},{91,92,93,94,95,96,97,98,99,100}};
    System.out.println(spiralOrder(matrix));
  }

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
