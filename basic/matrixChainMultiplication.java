public class matrixChainMultiplication {

    public static int mCM(int[] arr, int i, int j, int[][] dp){
        if(i>=j)
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = mCM(arr,i,k,dp) + mCM(arr,k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(temp,min);
        }
        return dp[i][j] = min;
    }
    public static void main(String[] args) {
        int[] arr = {10,40,5,20,30};
        int[][] dp = new int[arr.length+1][arr.length+1];
        System.out.println(mCM(arr,1,arr.length-1,dp));
    }
}
