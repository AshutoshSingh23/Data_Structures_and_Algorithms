package dynamicProgramming;

public class longestcommonSubString {
    public static int lCS(String r, String s) {
        int n = r.length(), m = s.length();
        if (n == 0 || m == 0)
            return 0;
        if (r.charAt(n - 1) == s.charAt(m - 1))
            return 1 + lCS(r.substring(0, n - 1), s.substring(0, m - 1));
        return Math.max(lCS(r.substring(0, n - 1), s), lCS(r, s.substring(0, m - 1)));
    }

    public static int memolCS(String r, String s, int[][] memo) {
        int n = r.length(), m = s.length();
        if (n == 0 || m == 0)
            return 0;
        if (r.charAt(n - 1) == s.charAt(m - 1))
            return 1 + lCS(r.substring(0, n - 1), s.substring(0, m - 1));
        if (memo[n][m] != 0)
            return memo[n][m];
        return memo[n][m] = Math.max(lCS(r.substring(0, n - 1), s), lCS(r, s.substring(0, m - 1)));
    }

    public static int tblCS(String r, String s, int[][] memo) {
        int n = r.length(), m = s.length();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (r.charAt(i - 1) == s.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1]; 
                } 
                max = Math.max(memo[i][j],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "asgdj";
        String r = "asd";
        int n = r.length(), m = s.length();
        int[][] dp = new int[n + 1][m + 1];
        System.out.println(tblCS(r, s, dp));
    }
}
