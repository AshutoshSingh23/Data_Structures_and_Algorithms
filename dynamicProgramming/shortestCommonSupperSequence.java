package dynamicProgramming;

public class shortestCommonSupperSequence {
    
    static int[][] memo = new int[1001][1001];

    public static int memoLCS(String r, String s, int[][] memo) {
        int n = r.length(), m = s.length();
        if (n == 0 || m == 0)
            return 0;
        if (memo[n][m] != 0)
            return memo[n][m];
        if (s.charAt(m - 1) == r.charAt(n - 1))
            return memo[n][m] = 1 + memoLCS(r.substring(0, n - 1), s.substring(0, m - 1), memo);
        return memo[n][m] = Math.max(memoLCS(r.substring(0, n - 1), s, memo), memoLCS(r, s.substring(0, m - 1), memo));
    }

    public static int tdLCS(String r, String s, int[][] memo) {
        int n = r.length(), m = s.length();
        for (int i = 1; i < r.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (s.charAt(j - 1) == r.charAt(i - 1))
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[n][m];
    }





    public static void main(String[] args) {
        String s = "abcgh";
        String r = "acef";
        int n = r.length(), m = s.length(), l = tdLCS(r, s, memo);
        System.out.println(l);
        System.out.println(n+m-l);
    }

}
