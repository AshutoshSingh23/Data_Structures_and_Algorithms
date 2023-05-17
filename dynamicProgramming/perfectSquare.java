package dynamicProgramming;

public class perfectSquare {
    public static int countSum(int sum, int[] memo) {
        int count = 1;
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return -1;
        }
        if (memo[sum] != 0)
            return memo[sum];

        int min = Integer.MAX_VALUE;
        int m = (int)Math.floor(Math.sqrt(sum));
        for (int i = 1; i < m+1; i++) {
            int c = countSum(sum - i*i, memo);
            if(c>=0 && c<min)
                min = c;

        }

        if (min == Integer.MAX_VALUE) {
            return memo[sum] = -1;
        }
        count += min;
        return memo[sum] = count;
        
    }

    public static void main(String[] args) {
        int n = 3;
        int[] memo = new int[n + 1];
        int minCount = countSum(n, memo);
        System.out.println("=======");
        System.out.println(minCount);
        System.out.println("=======");
    }
}
