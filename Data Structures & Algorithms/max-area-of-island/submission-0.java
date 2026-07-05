class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            for(int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++) {
                if(grid[rowIdx][colIdx] == 1 && vis[rowIdx][colIdx] == false) {
                    int count = 1 + dfs(grid, rowIdx, colIdx, vis);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int rowIdx, int colIdx, boolean[][] vis) {
        int count = 0;
        vis[rowIdx][colIdx] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] direction : directions) {
            int newX = direction[0] + rowIdx;
            int newY = direction[1] + colIdx;
            if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[newX].length
                && vis[newX][newY] == false && grid[newX][newY] == 1) {
                    count += 1 + dfs(grid, newX, newY, vis);
                }
        }
        return count;
    }
}
