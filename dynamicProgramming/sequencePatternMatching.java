package dynamicProgramming;

public class sequencePatternMatching {
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

    public static void main(String[] args) {
        String s = "aabccgba";
        String r = "acf";
        int l = tdLCS(r, s), m = s.length(), n =  r.length();
        System.out.println(l);
        if(l==n||l==m)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
