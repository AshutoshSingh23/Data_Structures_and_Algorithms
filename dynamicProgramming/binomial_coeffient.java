package dynamicProgramming;

public class binomial_coeffient {

    public static long nCr(int n, int r){
        
        int a = n-r;
        if(a<0){
            return -1;
        }
        if(r>a) r = a;
        /*long[][] dp = new long[n+1][r+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=r;j++){
                if(j == 0)  dp[i][j] = 1;
                if(i>0 && j>0){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][r];*/
        long[] dp = new long[r+1];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            for(int j=1;j<=r;j++){
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[r];
    }
    public static void main(String[] args) {
        int n = 4,r = 2;
        System.out.println(nCr(n,r));
    }
    
}
