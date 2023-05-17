package dynamicProgramming;

public class pallindromePartioning {
    
    public static boolean pallindromeCheck(String s, int i, int j){
        s = s.substring(i,j+1);
        String r = "";
        int l = s.length()-1;
        while(l>=0){
            r+=s.charAt(l);
            l--;
        }
        if(s.equals(r))
            return true;
        return false;
    }

    public static int recurPaP(String s, int i, int j) {
        if(i>=j)
            return 0;
        if(pallindromeCheck(s,i,j))
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = recurPaP(s, i, k) + recurPaP(s, k+1, j) + 1;
            min = Math.min(min, temp);
        }
        return min;
    }

    public static int memoPaP(String s, int i, int j,int[][] memo) {
        if (i >= j)
            return 0;
        if (pallindromeCheck(s, i, j))
            return 0;
        if(memo[i][j]!=0)
            return memo[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = memoPaP(s, i, k, memo) + memoPaP(s, k + 1, j, memo) + 1;
            min = Math.min(min, temp);
        }
        return memo[i][j] = min;
    }


    public static int optMemoPaP(String s, int i, int j, int[][] memo) {
        if (i >= j)
            return 0;
        if (pallindromeCheck(s, i, j))
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int l,r;
            if(memo[i][k]!=0)
                l = memo[i][k];
            else
                l = optMemoPaP(s, i, k, memo);

            if(memo[k+1][j] != 0)
                r = memo[k+1][j];
            else
                r = optMemoPaP(s, k+1, j, memo);
            int temp = l + r + 1;
            min = Math.min(min, temp);
        }
        return memo[i][j] = min;
    }
    public static void main(String[] args) {

        String s = "ntin";
        int[][] memo = new int[s.length()+1][s.length()+1];
        System.out.println(optMemoPaP(s, 0, s.length() - 1,memo));

    }
}
