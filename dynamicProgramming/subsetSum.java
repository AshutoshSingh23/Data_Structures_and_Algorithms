package dynamicProgramming;


public class subsetSum {

    static int count = 0;

    public static boolean check(int[] arr, int i, int sum, boolean[][] dp) {
        if (sum == 0)
            return true;
        if (sum < 0 || i <= 0)
            return false;
        if (dp[i][sum] == true)
            return true;
        return dp[i][sum] = check(arr, i-1, sum, dp) || check(arr, i - 1, sum - arr[i-1], dp);
    }

    public static int countSum(int[] arr, int sum, int[][] dp, int s) {
        /*for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];*/
        if(sum == 0)
            return 1;
        if(sum<0||s<=0)
            return 0;
        if(dp[s][sum]!=0){
            return dp[s][sum];
        }
        return dp[s][sum] = countSum(arr, sum-arr[s-1], dp, s-1) + countSum(arr , sum, dp, s-1);
    }

    public static void main(String[] args) {
        int[] arr = { 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83,
                22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45,
                63, 58, 38, 60, 24, 42, 30, 79, 17, 36 };
        int n = 2191;
        int[][] dp = new int[arr.length + 1][n+1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 0)
                    dp[i][j] = 1;
            }
        }
        boolean[][] memo = new boolean[arr.length + 1][n + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 0)
                    memo[i][j] = true;
            }
        }
        System.out.println(check(arr,arr.length,n,memo));
        count = countSum(arr, n, dp, arr.length);
        System.out.println(count);
    }
    
}
