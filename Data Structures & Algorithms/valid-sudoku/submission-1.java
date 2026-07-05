class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int rowIdx = 0; rowIdx < board.length; rowIdx++) {
            Set<Character> rowData = new HashSet<>();
            for(int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
                 if(board[rowIdx][colIdx] == '.') continue;
                 boolean isAdded = rowData.add(board[rowIdx][colIdx]);
                 if(isAdded == false) {
                    return false;
                 }
            }
        }

        for(int colIdx = 0; colIdx < board.length; colIdx++) {
            Set<Character> colData = new HashSet<>();
            for(int rowIdx = 0; rowIdx < board.length; rowIdx++) {
                if(board[rowIdx][colIdx] == '.') continue;
                boolean isAdded = colData.add(board[rowIdx][colIdx]);
                if(isAdded == false) {
                    return false;
                }
            }
        }

        int startRowIdx = 0; 
        int endRowIdx = startRowIdx + 2;
        while (startRowIdx < board.length && endRowIdx < board.length) {
          //  System.out.println("StartRowIdx " + startRowIdx + " endRowIdx " + endRowIdx + " StartColdIdx " + startColIdx + " endColIdx "+ endColIdx);
            Set<Character> boxData = new HashSet<>();
            for(int rowIdx = startRowIdx; rowIdx <= endRowIdx; rowIdx++) {
                for(int colIdx = 0; colIdx <= 2; colIdx++) {
                    if(board[rowIdx][colIdx] == '.') continue;
                    boolean isAdded = boxData.add(board[rowIdx][colIdx]);
                    if(isAdded == false) {
                        return false;
                    }
                }
            }

            boxData = new HashSet<>();
            for(int rowIdx = startRowIdx; rowIdx <= endRowIdx; rowIdx++) {
                for(int colIdx = 3; colIdx <= 5; colIdx++) {
                    if(board[rowIdx][colIdx] == '.') continue;
                    boolean isAdded = boxData.add(board[rowIdx][colIdx]);
                    if(isAdded == false) {
                        return false;
                    }
                }
            }


            boxData = new HashSet<>();
            for(int rowIdx = startRowIdx; rowIdx <= endRowIdx; rowIdx++) {
                for(int colIdx = 6; colIdx <= 8; colIdx++) {
                    if(board[rowIdx][colIdx] == '.') continue;
                    boolean isAdded = boxData.add(board[rowIdx][colIdx]);
                    if(isAdded == false) {
                        return false;
                    }
                }
            }
            startRowIdx = endRowIdx + 1;
            endRowIdx = startRowIdx + 2;
        }
        return true;
    }
}
