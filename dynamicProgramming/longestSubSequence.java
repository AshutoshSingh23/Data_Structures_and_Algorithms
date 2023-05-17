package dynamicProgramming;

import java.util.Scanner;

public class longestSubSequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length + 1; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length + 1; j++) {
                if (dp[j] >= nums[i]) {
                    dp[j] = nums[i];
                    System.out.println(i + ":" + nums[i]);
                    break;
                }
            }
        }
        int i = 0;
        for (i = nums.length; i > 0; i--) {
            if (dp[i] != Integer.MAX_VALUE) {
                break;
            }
        }
        return i;
        /*int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max =0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>dp[max])   max = i;
        }
        return dp[max];*/
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)   
            arr[i] = sc.nextInt();
        System.out.println(lengthOfLIS(arr));
        sc.close();
    }    
}
