package dynamicProgramming;

public class distinctSubsequences {
    public static int dsRecur(String s, String t, int i, int j, int[][] dp){
        //System.out.println(i+" "+j+" "+ s.length() +" " + t.length());
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)!=t.charAt(j))
            return dp[i][j] = dsRecur(s,t,i+1,j,dp);
        return dp[i][j] = dsRecur(s,t,i+1,j+1,dp) + dsRecur(s,t,i+1,j,dp);
    }
    public static int dsTD(String s, String t, int[][] dp){
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=t.length();j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                else if(i==0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + ((s.charAt(i-1)==t.charAt(j-1))?dp[i-1][j-1]:0);
            }
        }
        return dp[s.length()][t.length()];
    }
    public static void main(String[] args) {
        String r = "rabbbit";
        String s = "rabbit";
        int n = r.length(), m = s.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j] = -1;
        System.out.println(dsRecur(r, s, 0 , 0, dp));
    }
}
