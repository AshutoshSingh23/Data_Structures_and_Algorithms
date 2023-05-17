package backTracking;

import java.util.HashSet;
import java.util.Set;

public class sudokuSolver {


    public static boolean isValidSudoku(int[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != 0) {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }


    public static boolean sudokuSolve(int[][] arr, int row, int col) {
        if(col==9){
            row++;
            col = 0;
        }
        if(row == 9)
            return true;
        int ch = arr[row][col];
        if(ch==0){
            for(int j=1;j<10;j++){
                arr[row][col] = j;
                if(isValidSudoku(arr)){
                    if(sudokuSolve(arr,row,col+1))
                        return true;
                }
                arr[row][col] = 0;
            }
        }else{
            return sudokuSolve(arr,row,col+1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[9][9];
        arr[1][0] = 8;
        sudokuSolve(arr, 0, 0);

        for (int[] x : arr) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
