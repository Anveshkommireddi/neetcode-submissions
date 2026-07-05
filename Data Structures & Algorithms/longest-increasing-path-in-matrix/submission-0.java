class Solution {

    public int longestIncreasingPath(int[][] matrix) {
		Integer[][] mem = new Integer[matrix.length][matrix[0].length];
		int result = Integer.MIN_VALUE;
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			for (int colIdx = 0; colIdx < matrix[rowIdx].length; colIdx++) {
				int maxLength = maxIncLen(matrix, rowIdx, colIdx, mem);
				result = Math.max(result, maxLength);
			}
		}
		return result;
	}

	private int maxIncLen(int[][] matrix, int rowIdx, int colIdx, Integer[][] mem) {
		if (rowIdx >= matrix.length || colIdx >= matrix[0].length || rowIdx < 0 || colIdx < 0)
			return 0;
		if (null != mem[rowIdx][colIdx])
			return mem[rowIdx][colIdx];
		int[][] directions = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
		int result = 0;
		for (int[] direction : directions) {
			int newX = direction[0] + rowIdx;
			int newY = direction[1] + colIdx;
			if (newX < matrix.length && newX >= 0 && newY < matrix[newX].length && newY >= 0
					&& matrix[newX][newY] > matrix[rowIdx][colIdx]) {
				int tempRes = maxIncLen(matrix, newX, newY, mem);
				result = Math.max(tempRes, result);
			}
		}
		return mem[rowIdx][colIdx] = 1 + result;
	}
}
