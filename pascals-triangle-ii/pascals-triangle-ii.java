class Solution {
  public List<Integer> getRow(int rowIndex) {

    List<Integer> curRow = new ArrayList<>(); curRow.add(1);
    int r = 0;
    while (r < rowIndex) {
      for (int i = 0; i < curRow.size()-1; i++) {
        curRow.set(i, curRow.get(i)+curRow.get(i+1)); 
      }
      curRow.add(0, 1);
      r++;
    }
    return curRow;
  }
}