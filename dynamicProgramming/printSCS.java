package dynamicProgramming;

public class printSCS {

    static int[][] memo = new int[1001][1001];

    public static int tdLCS(String r, String s) {
        int n = r.length(), m = s.length();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(j - 1) == r.charAt(i - 1))
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
            }
        }
        return memo[n][m];
    }

    public static int memoLCS(String r, String s){
        int n =r.length(),m=s.length();
        if(n==0||m==0)
            return 0;
        if(s.charAt(m-1)==r.charAt(n-1))
            return 1+memoLCS(r.substring(0,n-1), s.substring(0,m-1));
        if(memo[n][m]!=0)
            return memo[n][m];
        return memo[n][m] = Math.max(memoLCS(r.substring(0, n - 1), s),memoLCS(r, s.substring(0, m - 1)));
    }

    public static void printsCS(String r, String s){
        int i = r.length(),j=s.length();
        String t="";
        while(i>0&&j>0){
            if(memo[i-1][j]==memo[i][j-1]){
                t+=s.charAt(j-1);
                i--;
                j--;
            }else if(memo[i-1][j]>memo[i][j-1]){
                t+=r.charAt(i-1);
                i--;
            }else if (memo[i - 1][j] < memo[i][j - 1]){
                t+=s.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            t+=r.charAt(i-1);
            i--;
        }
        while (j > 0) {
            t += s.charAt(j - 1);
            j--;
        }
        String u = "";
        int h = t.length() - 1;
        while (u.length() != t.length()) {
            u += t.charAt(h);
            h--;
        }
        System.out.println(u);
    }

    public static void printMemo(String r, String s) {
        int n = r.length(), m = s.length();
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "abcef";
        String r = "acdef";
        System.out.println(tdLCS(r, s));
        printsCS(r, s);
        printMemo(r, s);
    }
    
}
