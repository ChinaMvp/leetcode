package com.mvp.learn.leetcode.solution.SudokuSolver;

/**
 * 37、解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例1
 * 输入：board = [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出：[
 * ["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]
 * ]
 *
 */
public class SudokuSolver {
    public boolean solveSudoku(char[][] board) {
        return backTracking(board);
    }

    /**
     * 计算数独结果
     *
     * @param board 棋盘
     * @return 数独结果
     */
    public boolean backTracking(char[][] board) {
        // 逐行逐列遍历棋盘
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // (i,j)位置已有数字，则跳过
                if (board[i][j] != '.') {
                    continue;
                }

                // 对于(i,j)位置，递归遍历这个位置放9个数字的可能性
                for (char value = '1'; value <= '9'; value++) {
                    // (i,j) 这个位置放value是否合适
                    if (isValidShudu(i, j, value, board)) {
                        board[i][j] = value;
                        // 如果找到一组解, 就立刻返回
                        if (backTracking(board)) {
                            return true;
                        }

                        board[i][j] = '.';
                    }
                }
                // 对于(i,j)位置, 从数值1到数值9都找完了, 还没有合适的, 则说明无解, 直接返回false
                return false;
            }
        }

        // 遍历完, 没有返回false, 则说明已找到棋盘上合适的位置
        return true;
    }

    /**
     *  判断棋盘是否合法有三个条件：
     *     1.同行是否重复
     *     2.同列是否重复
     *     3.9宫格内是否重复
     * @param row 行
     * @param col 列
     * @param value 值
     * @param board 棋盘
     * @return true: 有效, false: 非法
     */
    private boolean isValidShudu(int row, int col, int value, char[][] board) {
        // 第row行是否已存在value
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // 第col列是否已存在value
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // (row, col)所属的9宫格里是否已存在value
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuSolver obj = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean isFindValid = obj.solveSudoku(board);
        if (isFindValid) {
            System.out.println("Find valid solution, Congratulations!");
        } else {
            System.out.println("Not find valid solution, please check!");
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
