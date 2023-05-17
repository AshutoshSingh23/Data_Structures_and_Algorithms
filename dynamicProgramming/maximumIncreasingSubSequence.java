package dynamicProgramming;

import java.util.Scanner;

public class maximumIncreasingSubSequence {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = nums[i];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[max])
                max = i;
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(lengthOfLIS(arr));
        sc.close();
    }
}
