package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class maxAreaRectangleBinaryMatrix {

    public static int maxArea(int[][] board, int row, int n){

        int[] arr = new int[n] ;
        for(int i=0;i<n;i++)
            arr[i] = board[row][i];
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        List<Integer> st = new ArrayList<>();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                st.add(-1);
            } else if (stk.peek() < arr[i]) {
                st.add(ind.peek());
            } else {
                stk.pop();
                ind.pop();
                i--;
                continue;
            }
            stk.push(arr[i]);
            ind.push(i);
        }

        while (!stk.isEmpty()) {
            stk.pop();
            ind.pop();
        }

        Stack<Integer> stc = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                stc.push(n);
            } else if (stk.peek() < arr[i]) {
                stc.push(ind.peek());
            } else {
                stk.pop();
                ind.pop();
                i++;
                continue;
            }
            stk.push(arr[i]);
            ind.push(i);
        }
        int max = 0;
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (stc.pop() - st.get(i) - 1) * arr[i];
            if (max < ar[i])
                max = ar[i];
        }

        return max;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] binMat = {{0,1,1,0}, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }};
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(binMat[i][j]!=0){
                    binMat[i][j]+=binMat[i-1][j];
                }else{
                    binMat[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,maxArea(binMat, i, n));
        }
        System.out.println(max);
    }
}
