package dynamicProgramming;

public class editDistance {
    
    public static int edRecur(String s, String t, int i, int j, int[][] dp){
        //System.out.println(i+" "+j+" "+ s.length() +" " + t.length());
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j] = edRecur(s,t,i+1,j+1,dp);
        return dp[i][j] = 1+ Math.min(edRecur(s,t,i+1,j+1,dp),Math.min(edRecur(s,t,i+1,j,dp),edRecur(s,t,i,j+1,dp)));
    }
    public static int edTD(String s, String t, int[][] dp){
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<t.length()+1;j++){
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i; 
                else{
                    if(s.charAt(i-1)==t.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    public static void main(String[] args) {
        String s = "geeks";
        String r = "geseks";
        int n = r.length(), m = s.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j] = -1;
        System.out.println(edRecur(r, s, 0, 0, dp));
    }
}
