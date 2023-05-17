package backTracking;

public class nQueens {

    public static boolean isSafe(int[][] arr, int row, int col, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == row && j== col)
                    continue;
                else if(i == row){
                    if(arr[i][j] == 1)
                        return false;
                }else if(j == col){
                    if(arr[i][j] == 1)
                        return false;
                }else if(j == i + col - row){
                    if(arr[i][j] == 1)
                        return false;
                }else if(j == col + row -i){
                    if (arr[i][j] == 1)
                        return false;
                }
            }
        }
        return true;
    }
    
    public static int[][] nQueen(int[][] arr, int n, int row, int col){
        if(row == n)
            return arr;
        if(col == n)
            return arr;
        if(isSafe(arr, row, col, n)){
            arr[row][col] = 1;
            return nQueen(arr, n, row+1, col);
        }
        return nQueen(arr, n, row, col+1);
    }
    
    public static boolean nQueen(int[][] arr, int n, int row){
        if(row == n)
            return true;
        for(int col=0;col<n;col++){
            if (isSafe(arr, row, col, n)) {
                arr[row][col] = 1;
                if(nQueen(arr,n,row+1))
                    return true;
                arr[row][col] = 0;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int n = 8;
        int[][] arr = new int[n][n];
        nQueen(arr,n,0);

        for(int[] x : arr){
            for(int y : x) 
                System.out.print(y+" ");
            System.out.println();
        }
    }
}
