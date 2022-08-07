class Solution {
  public List<List<Integer>> generate(int numRows) {

    List<List<Integer>> PascalsTri = new ArrayList<List<Integer>>();
    Integer[] row = new Integer[1];
    row[0] = 1; row[row.length-1] = 1;
    PascalsTri.add(Arrays.asList(row));
    for (int i = 1; i < numRows; i++) {
      row = new Integer[i+1];
      row[0] = 1; row[row.length-1] = 1;
      int prevRowPos = 0;
      for (int curRowPos = 1; curRowPos < row.length-1; curRowPos++) {
        row[curRowPos] = PascalsTri.get(i-1).get(prevRowPos)+PascalsTri.get(i-1).get(prevRowPos+1);
        prevRowPos++;
      }
      PascalsTri.add(Arrays.asList(row));
    }
    return PascalsTri;
  }
}