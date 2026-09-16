package ashish.btech.dsa.lc.medium;

public class LC36 {

    public boolean isRowValid(char[][] board, int rowIndx) {
        boolean[] exists = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int num = board[rowIndx][i] - 48;
            if (exists[num]) return false;
            else exists[num] = true;
        }
        return true;
    }

    public boolean isColumnValid(char[][] board, int columnIndx) {
        boolean[] exists = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int num = board[i][columnIndx] - 48;
            if (exists[num]) return false;
            else exists[num] = true;
        }
        return true;
    }

    public boolean isBlockValid(char[][] board, int boxX, int boxY) {
        boolean exist[] = new boolean[9];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {}
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        return false;
    }
}
