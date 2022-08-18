class Solution {
  
  int[][] subboxArr = new int[][]{{1,2,3},
                                  {4,5,6},
                                  {7,8,9}};
  
  public boolean isValidSudoku(char[][] board) {
    
    Map<Integer, List<Character>> rowMap = new HashMap<Integer, List<Character>>();
    Map<Integer, List<Character>> colMap = new HashMap<Integer, List<Character>>();
    Map<Integer, List<Character>> subboxMap = new HashMap<Integer, List<Character>>();
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.')
          continue;
        // look up or create subboxList
        int subboxNum = subboxArr[whichSubbox(i)][whichSubbox(j)];
        if (subboxMap.containsKey(subboxNum)) {
          if (subboxMap.get(subboxNum).contains(board[i][j]))
            return false;
          // System.out.println(subboxMap.get(subboxNum));
          subboxMap.get(subboxNum).add(board[i][j]);
        }
        else {
          List<Character> subbox = new ArrayList<>();
          subbox.add(board[i][j]);
          subboxMap.put(subboxNum, subbox);
        }
        // look up or create row
        if (rowMap.containsKey(i)) {
          if (rowMap.get(i).contains(board[i][j]))
            return false;
          rowMap.get(i).add(board[i][j]);
        }
        else {
          List<Character> row = new ArrayList<>();
          row.add(board[i][j]);
          rowMap.put(i, row);
        }
        // look up or create col
        if (colMap.containsKey(j)) {
          if (colMap.get(j).contains(board[i][j]))
            return false;
          colMap.get(j).add(board[i][j]);
        }
        else {
          List<Character> col = new ArrayList<>();
          col.add(board[i][j]);
          colMap.put(j, col);
        }
      } 
    }
    
    return true;
  }
  
  private int whichSubbox(int dim) {
    if (0 <= dim && dim <= 2)
      return 0;
    if (3 <= dim && dim <= 5)
      return 1;
    if (6 <= dim && dim <= 8)
      return 2;
    return 0;
  }
  
}