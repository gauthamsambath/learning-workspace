package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // checking for column and row wise
        Set<Character> rowUniqueElements = new HashSet<>();
        Set<Character> columnUniqueElements = new HashSet<>();
        for (int i= 0 ;i < 9 ;i++){
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j]!='.' && rowUniqueElements.contains(board[i][j])) {
                    return false;
                } else {
                    rowUniqueElements.add(board[i][j]);
                }
                if (board[j][i]!='.' && columnUniqueElements.contains(board[j][i])) {
                    return false;
                } else {
                    columnUniqueElements.add(board[j][i]);
                }
            }
            rowUniqueElements.clear();
            columnUniqueElements.clear();
        }

        // checking for grid wise
        Set<Character> gridUniqueElements = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 3*i; k < 3+3*i; k++) {
                    for (int l = 3*j; l < 3+3*j; l++) {
                        if (board[k][l]!='.' && gridUniqueElements.contains(board[k][l])) {
                            return false;
                        } else {
                            gridUniqueElements.add(board[k][l]);
                        }
                    }
                }
                gridUniqueElements.clear();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();

        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
                           {'6','.','.','1','9','5','.','.','.'},
                           {'.','9','8','.','.','.','.','6','.'},
                           {'8','.','.','.','6','.','.','.','3'},
                           {'4','.','.','8','.','3','.','.','1'},
                           {'7','.','.','.','2','.','.','.','6'},
                           {'.','6','.','.','.','.','2','8','.'},
                           {'.','.','.','4','1','9','.','.','5'},
                           {'.','.','.','.','8','.','.','7','9'},};

        System.out.println("The above sudoku is"+(validSudoku.isValidSudoku(sudoku)?" Valid":" Not Valid"));

    }
}
