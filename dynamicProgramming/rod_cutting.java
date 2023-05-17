package dynamicProgramming;

public class rod_cutting {

    public static int maxProfit(int[][] dp, int[] l, int[] p, int sum, int i){
        if(sum<0||i<=0){
            return 0;
        }
        if (dp[i][sum] != 0) {
            return dp[i][sum];
        }
        if(sum >=l[i-1]){
            return dp[i][sum] = Math.max(maxProfit(dp, l, p, sum, i - 1), maxProfit(dp, l, p, sum - l[i - 1], i)+p[i-1]);
        }else{
            return dp[i][sum] = maxProfit(dp, l, p, sum, i - 1);
        }
        
    }
    public static void main(String[] args) {
        int[] l = { 1, 2, 3, 4, 5, 6, 7, 8};
        int[] p = { 1, 5, 8, 9, 10, 17, 17, 20};
        int length = 8;
        int[][] dp = new int[l.length+1][length+1];
        System.out.println(maxProfit(dp,l,p,length,p.length));
    }
    
}
