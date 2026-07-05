class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            for(int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++) {
                if(grid[rowIdx][colIdx] == '1' && vis[rowIdx][colIdx] == false) {
                    dfs(grid, rowIdx, colIdx, vis);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int rowIdx, int colIdx, boolean[][] vis) {
        vis[rowIdx][colIdx] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] direction : directions) {
            int newX = rowIdx + direction[0];
            int newY = colIdx + direction[1];
            if(newX >= 0 && newY >=0 && newX < grid.length && newY < grid[newX].length 
               && vis[newX][newY] == false && grid[newX][newY] == '1') {
                dfs(grid, newX, newY, vis);
            } 
        }
    }
}
