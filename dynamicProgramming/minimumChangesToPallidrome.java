package dynamicProgramming;

public class minimumChangesToPallidrome {
    static int[][] memo = new int[1001][1001];

    public static int tdLCS(String r, String s, int[][] memo) {
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

    public static void main(String[] args) {
        String s = "abcgba";
        String r = "";
        int n = s.length() - 1;
        while (r.length() != s.length()) {
            r += s.charAt(n);
            n--;
        }
        int l = tdLCS(r, s, memo), m = s.length();
        System.out.println(l);
        System.out.println(m-l);
    }
}
