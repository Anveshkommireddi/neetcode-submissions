class Solution {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            for(int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++) {
                if(grid[rowIdx][colIdx] == 2) {
                    queue.add(new int[] {rowIdx, colIdx, 0});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int cRow = currNode[0];
            int cCol = currNode[1];
            int cTime = currNode[2];

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int[] direction : directions) {
                int nRow = cRow + direction[0];
                int nCol = cCol + direction[1];
                if(nRow >= 0 && nRow < grid.length && 
                   nCol >= 0 && nCol < grid[nRow].length && 
                   grid[nRow][nCol] == 1) {
                   int nTime = cTime + 1;
                   grid[nRow][nCol] = 2;
                   queue.add(new int[] {nRow, nCol, nTime});
                   result = Math.max(result, nTime);
                }
            }
        }
        boolean allRotten = checkRotten(grid);
        return allRotten == true ? result : -1;
    }

    private boolean checkRotten(int[][] grid) {
        boolean result = true;
        for(int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            for(int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++) {
                if(grid[rowIdx][colIdx] == 1) {
                    return false;
                }
            }
        }
        return result;
    }
}
