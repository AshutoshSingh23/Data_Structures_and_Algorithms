package dynamicProgramming;

public class longestRepeatingSubsequence {
    
    static int[][] memo = new int[1001][1001];

    public static int tdLCS(String r, String s) {
        int n = r.length(), m = s.length();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(j - 1) == r.charAt(i - 1) && i!=j){
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                    System.out.println(s.charAt(j-1));
                }else
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
            }
        }
        return memo[n][m];
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
        String s = "aabcccba";
        String r = s;
        System.out.println(tdLCS(r, s));
        printMemo(r, s);
    }
}
