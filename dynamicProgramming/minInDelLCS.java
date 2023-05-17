package dynamicProgramming;

public class minInDelLCS {

    static int[][] memo = new int[1001][1001];

    public static int memoLCS(String r,String s,int[][] memo){
        int n = r.length(),m = s.length();
        if(n==0||m==0)
            return 0;
        if(s.charAt(m-1)==r.charAt(n-1))
            return 1+memoLCS(r.substring(0, n-1), s.substring(0,m-1), memo);
        if(memo[n][m]!=0)
            return memo[n][m];
        return Math.max(memoLCS(r, s.substring(0,m-1), memo),memoLCS(r.substring(0, n-1), s, memo));
    }
    public static void main(String[] args) {
        String s = "abcgh";
        String r = "acef";
        int n = r.length(), m = s.length(), l = memoLCS(r, s, memo), ins = n-l, del = m-l;

        System.out.println(l);
        System.out.println(ins + del);
    }
    
}
