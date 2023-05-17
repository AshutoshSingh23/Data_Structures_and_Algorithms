package dynamicProgramming;

public class longestIncThenDec {

    public static int inc(final int[] a, int i) {
        if (i == 0)
            return 0;
        int[] dp = new int[i + 2];
        int p = 2, j = i;
        int min = Integer.MIN_VALUE;
        for (p = 0; p < dp.length; p++) {
            dp[p] = min;
        }
        p=2;
        dp[1] = a[i];
        i--;
        while (i>=0&&p<dp.length) {
            if (dp[p] < a[i]) {
                if(a[i]>=dp[1]){
                    i--;
                    continue;
                }
                dp[p] = a[i];
                i--;
                p = 2;
            } else {
                p++;
            }
        }
        for (int k = dp.length - 1; k >= 0; k--) {
            if (dp[k] != Integer.MIN_VALUE){
                System.out.println(k + " inc " + j);
                return k;
            }
        }
        return 0;
    }

    public static int dec(final int[] a, int i) {
        if (i == a.length - 1)
            return 0;
        int[] dp = new int[a.length - i + 1];
        int p = 0,j=i;
        int min = Integer.MIN_VALUE;
        for (p = 0; p < dp.length; p++) {
            dp[p] = min;
        }
        p = 2;
        dp[1] = a[i];
        i++;
        while (i < a.length) {
            if (dp[p] < a[i]) {
                if(a[i]>=dp[1]){
                    i++;
                    continue;
                }
                dp[p] = a[i];
                i++;
                p = 2;
            } else {
                p++;
            }
        }
        for (int k = dp.length - 1; k >= 0; k--) {
            if (dp[k] != Integer.MIN_VALUE){
                System.out.println(k+" dec "+j);
                return k;
            }
        }
        return 0;
    }

    public static int longestSubsequenceLength(final int[] A) {
        if (A.length<3)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++)
            max = Math.max(max, inc(A, i) + dec(A, i) - 1);
        return max;
    }
    public static void main(String[] args) {
        //int[] arr = {1,2,1};
        int[] arr = { 1, 10, 9, 8, 9, 12, 2 };
        System.out.println(longestSubsequenceLength(arr));
    }
    
}