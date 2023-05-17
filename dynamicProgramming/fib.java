package dynamicProgramming;

import java.util.*;

public class fib {
    public static int fibo(int n,int[] memo){
        if(n == 1){
            memo[n] = 0;
            return 0;
        }
        if(n == 2){
            memo[n] = 1;
            return 1;
        }
        if(memo[n] == -1){
            memo[n] = fibo(n-1,memo) + fibo(n-2,memo);    
        }
        return memo[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
        int[] memo = new int[n+1];
        for(int i=0;i<n+1;i++){
            memo[i] = -1;
        }
        int t = fibo(n,memo);
        System.out.println(t);
        sc.close();
    }
}
