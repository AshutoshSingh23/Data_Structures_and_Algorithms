package dynamicProgramming;

public class summationOf157_memo {
    public static int countSum(int[] arr, int sum, int[] memo) {
        int count = 1;
        int[] cur = new int[arr.length];
        if (sum == 0) {
            return 0;
        }
        
        if(memo[sum]!=-1)
            return memo[sum];
        
        for (int i = 0; i < arr.length; i++) {
            if(sum-arr[i]>=0){
                cur[i] = countSum(arr, sum - arr[i],memo);
                if(cur[i]<0)    cur[i] = Integer.MAX_VALUE;
            }
        }
        int min = 0;
        //System.out.println("-------");
        for (int i = 0; i < arr.length; i++) {
            if (cur[i] < cur[min])
                min = i;
            //System.out.println(cur[i]);
        }
        //System.out.println("-------");
        count += cur[min];
        memo[sum] = count;
        return count;
    }

    public static void main(String[] args) {
        /*int[] arr = {186,419,83,408};
        int n = 6249;*/
        /*int[] arr = { 10,2,5 };
        int n = 10;*/
        int[] arr = {2};
        int n = 3;
        int[] memo = new int[n + 1];
        for(int i=0;i<n+1;i++){
            memo[i] = -1;
        }
        memo[0] = 0;
        int minCount = countSum(arr, n, memo);
        System.out.println("=======");
        System.out.println(minCount);
        System.out.println("=======");
        /*for(int x : memo){
            System.out.println(x);
        }*/
    }
}
