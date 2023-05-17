package dynamicProgramming;

public class minimumSubsetSumDiff {
    

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7 };
        int n = 0;
        for(int i=0;i<arr.length;i++){
            n += arr[i];
        }
        int sum = n;
        n /= 2;
        boolean[][] dp = new boolean[arr.length + 1][n + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int i;
        for (i = n; i >= 0; i--) {
            if(dp[arr.length][i] == true)
                break;
        }
        int count = sum - 2*i;
        System.out.println(count);
    }
}
