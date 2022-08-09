package ARRAY_AND_STRING.introduction_to_2d_array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
  
  public static void main(String[] args) {
    System.out.println(generate(1));
  }

  /**
   * # wooo
   */
  public static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> PascalsTri = new ArrayList<List<Integer>>();
    List<Integer> row = new ArrayList<>(2);
    row.set(0, 1); row.set(row.size()-1, 1);
    PascalsTri.add(row);
    for (int i = 1; i < numRows; i++) {
      row = new ArrayList<>(numRows+1);
      row.set(0, 1); row.set(row.size()-1, 1);
      int prevRowPos = 0;
      for (int curRowPos = 1; curRowPos < row.size()-1; curRowPos++) {
        row.set(curRowPos, PascalsTri.get(i-1).get(prevRowPos)+PascalsTri.get(i-1).get(prevRowPos+1));
        prevRowPos++;
      }
      PascalsTri.add(row);
    }
    return PascalsTri;
  }

}
