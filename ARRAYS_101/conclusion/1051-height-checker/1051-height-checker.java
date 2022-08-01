class Solution {
    public int heightChecker(int[] heights) {
        
        int[] heights2 = heights.clone();
        Arrays.sort(heights);
        int numWrong = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != heights2[i])
                numWrong++;
        }
        return numWrong;
    }
}