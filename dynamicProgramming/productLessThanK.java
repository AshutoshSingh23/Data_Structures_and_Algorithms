package dynamicProgramming;

public class productLessThanK {
    public static int fibo(int k, int[] arr) {
        int[][] dp = new int[k+1][arr.length+1];
        for(int i=1;i<k+1;i++){
            for(int j=1;j<arr.length+1;j++){
                dp[i][j] = dp[i][j-1];
                if(arr[j-1]<=i){
                    dp[i][j]+= 1 + dp[i/arr[j-1]][j-1];
                }
            }
        }
        return dp[k][arr.length];
    }

    public static void main(String[] args) {
        int k = 6;
        int [] arr = {1,3,5};
        
        int t = fibo(k, arr);
        System.out.println(t);
    }
}