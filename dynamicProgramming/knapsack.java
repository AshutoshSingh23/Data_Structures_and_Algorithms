package dynamicProgramming;

public class knapsack {


    public static int topbottomKnapsack(int w[], int v[], int n, int tw, int[][] memo) {
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < tw+1; j++) {
                if (i != 0 && j != 0) {
                    if (j - w[i - 1] < 0) {
                        memo[i][j] = memo[i - 1][j];
                        continue;
                    }
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return memo[n][tw]; 
    }

    public static int memoKnapsack(int w[], int v[], int n, int tw,int[][] memo){
        if(n<0||tw==0){
            return 0;
        }
        if(memo[n][tw]!=0)
            return memo[n][tw];
        if(tw>=w[n])
            return memo[n][tw] = Math.max(v[n]+memoKnapsack(w, v, n-1, tw-w[n],memo),memoKnapsack(w, v, n-1, tw,memo));
        else{
            return memo[n][tw] = memoKnapsack(w, v, n-1, tw,memo);
        }
    }

    public static int recurKnapsack(int w[], int v[], int n, int tw) {
        if (n < 0 || tw == 0) {
            return 0;
        }
        if (tw >= w[n])
            return Math.max(v[n] + recurKnapsack(w, v, n - 1, tw - w[n]), recurKnapsack(w, v, n - 1, tw));
        else {
            return recurKnapsack(w, v, n - 1, tw);
        }
    }

    public static void main(String[] args){
        int n = 4,tw =10;
        int[] v = {20,30,10,50};
        int[] w = {1,3,4,6};
        int[][] memo = new int[n+1][tw+1];
        System.out.println(memoKnapsack(w, v, n-1, tw, memo));
    }
    
}
