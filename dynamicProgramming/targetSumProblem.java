package dynamicProgramming;

public class targetSumProblem {

    public static boolean targetSumCheck(int i, int sum, int[] arr, boolean b){
        if(i < 0){
            if(sum==1)
                return true;
            else 
                return false;
        }
        if(b)
            sum += arr[i];
        else
            sum-=arr[i];
        return targetSumCheck(i-1, sum, arr, true) || targetSumCheck(i-1, sum, arr, false);
    }

    public static int targetSum(int[] arr, int sum, int i){
        if(sum==0)
            return 1;
        if(sum<0||i<0)
            return 0;
        return targetSum(arr, sum-arr[i], i-1) + targetSum(arr, sum, i - 1);
    }

    public static int memoTargetSum(int[] arr, int sum, int i, int[][] memo) {
        if (sum == 0)
            return 1;
        if (sum < 0 || i < 0)
            return 0;
        if(memo[i][sum]!=0)
            return memo[i][sum];
        return memo[i][sum] = targetSum(arr, sum - arr[i], i - 1) + targetSum(arr, sum, i - 1);
    }

    public static int tbTargetSum(int[] arr, int sum, int n, int[][] memo) {
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<j){
                    memo[i][j] = memo[i-1][j-arr[i-1]] + memo[i-1][j];
                }else if(arr[i-1]==j){
                    memo[i][j] = memo[i-1][j]+1;
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,9};
        //int n = arr.length;
        //System.out.println(targetSumCheck(n-1,0,arr,true)||targetSumCheck(n-1, 0, arr, false));
        int sum=0,n=arr.length;
        for(int i:arr)
            sum+=i;
        int r = 1;
        
        if(r%2==1){
            if (sum % 2 == 1){
                int s = (sum-r)/2;
                int[][] memo = new int[n + 1][s + 1];
                System.out.println(tbTargetSum(arr,s,n,memo));
            }else 
                System.out.println(-1);
        }else{
            if (sum % 2 == 0) {
                int s = (sum - r) / 2;
                System.out.println(targetSum(arr, s, n - 1));
            } else
                System.out.println(-1);
        }
    }
    
}
