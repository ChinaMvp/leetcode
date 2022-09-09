package com.mvp.learn.leetcode.solution.CheckValidSudoku;

import java.util.Arrays;

/**
 * 36、有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * 解法：求第 i 行、第 j 列，以及第 k 个 3*3 宫格是否含有相同数字，如果是，则返回 false。遍历结束，返回 true。
 */
public class CheckValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 行
        boolean[][] row = new boolean[9][9];
        // 列
        boolean[][] col = new boolean[9][9];
        // 9宫格
        boolean[][] sub = new boolean[9][9];
        // 逐行逐列遍历棋盘
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                // 数值
                int number = c - '0' - 1;
                // 该数值所属9宫格的序号
                int k = (i / 3) * 3 + j / 3;
                if (row[i][number] || col[j][number] || sub[k][number]) {
                    return false;
                }

                row[i][number] = true;
                col[j][number] = true;
                sub[k][number] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckValidSudoku obj = new CheckValidSudoku();
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
        boolean result = obj.isValidSudoku(board);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("result=" + result);
    }
}
