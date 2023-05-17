package dynamicProgramming;

public class maximiseProduct {
    public static int helper(int n, int product, boolean b) {
        if (n == 1 || n == 0)
            return product;
        if (n < 0)
            return -1;
        int max = 1;
        for (int i = 1; i <= n; i++) {
            if (b && i == n)
                continue;
            int c = helper(n - i, product * i, false);
            max = Math.max(c, max);
        }
        return product = max;
    }

    public static  int maxProduct(int n,boolean b){
        if(n==1||n==0)
            return 1;
        if(n<0)
            return -1;
        int max = 1;
        for(int i=1;i<=n;i++){
            if(b&&i==n)
                continue;
            int c = i*(maxProduct(n-i,false));
            max = Math.max(max,c);
        }
        return max;
    }

    public int memomaxProduct(int n, int[] dp, boolean b) {
        if (n == 1 || n == 0)
            return 1;
        if (n < 0)
            return -1;
        if (dp[n] > 0)
            return dp[n];
        int max = 1;
        for (int i = 1; i <= n; i++) {
            if (b && i == n)
                continue;
            int c = 1;
            if (dp[n - i] > 0 && n > i) {
                c = i * dp[n - i];
            } else {
                c = i * (memomaxProduct(n - i, dp, false));
            }
            max = Math.max(max, c);
        }
        return dp[n] = max;
    }

    public static int integerBreak(int n) {
        //return helper(n, 1, true);
        return maxProduct(3,true);
    }
    
    public static void main(String[] args){
        System.out.println(integerBreak(10));
    }
}
