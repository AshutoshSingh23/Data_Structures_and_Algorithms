package dynamicProgramming;

public class printLCS {

    static int[][] memo = new int[1001][1001];
    
    public static int recurLCS(String r, String s){
        int n = r.length(),m= s.length();
        if(n==0||m==0)
            return 0;
        if(s.charAt(m-1)==r.charAt(n-1))
            return 1+recurLCS(r.substring(0,n-1),s.substring(0, m-1));
        return Math.max(recurLCS(r.substring(0, n - 1), s), recurLCS(r, s.substring(0, m - 1))); 
    }

    public static int memoLCS(String r, String s, int[][] memo){
        int n = r.length(), m = s.length();
        if (n == 0 || m == 0)
            return 0;
        if(memo[n][m]!=0)
            return memo[n][m];
        if (s.charAt(m - 1) == r.charAt(n - 1))
            return memo[n][m] = 1 + memoLCS(r.substring(0, n - 1), s.substring(0, m - 1),memo);
        return memo[n][m] = Math.max(memoLCS(r.substring(0, n - 1), s, memo), memoLCS(r, s.substring(0, m - 1),memo));
    }

    public static int tdLCS(String r, String s, int[][] memo) {
        int n = r.length(), m = s.length();
        for(int i=1;i<r.length()+1;i++){
            for(int j=1;j<s.length()+1;j++){
                if(s.charAt(j-1)==r.charAt(i-1))
                    memo[i][j] = 1+ memo[i-1][j-1];
                else
                    memo[i][j] = Math.max(memo[i-1][j],memo[i][j-1]);
            }
        }
        return memo[n][m];
    }

    public static void printlCS(String r, String s, int[][] memo){
        String t = "";
        int n = r.length(), m = s.length();
        for (int i = n; i>0; i--) {
            for (int j = m; j > 0; j--) {
                if (memo[i-1][j]==memo[i][j-1]){
                    t+=r.charAt(i-1);
                    i--;
                }
                else if(memo[i - 1][j] > memo[i][j - 1]){
                    i--;
                    j++;
                }
            }
        }
        String u="";
        int h = t.length()-1;
        while(u.length()!=t.length()){
            u += t.charAt(h);
            h--;
        }
        System.out.println(u);
    }

    public static void main(String[] args) {
        String s = "abcef";
        String r = "acdef";
        System.out.println(tdLCS(r, s, memo));
        printlCS(r, s, memo);
    }
}
