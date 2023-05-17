package dynamicProgramming;

public class dp_coinChange {
    public static int countSum(int[] arr, int sum, int[] memo) {
        int count = 1;
        int[] cur = new int[arr.length];
        if (sum == 0) {
            return 0;
        }
        if(sum<0){
            return -1;
        }
        if (memo[sum] != 0)
            return memo[sum];

        for (int i = 0; i < arr.length; i++) {
            cur[i] = countSum(arr, sum - arr[i], memo);
            
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(cur[i]>=0&&cur[i]<min){
                min = cur[i];
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            return memo[sum] = -1;
        }
        count += min;
        return memo[sum] = count;
        /*Arrays.sort(cur);

        int min = 0, x = 0;
        // System.out.println("-------");
        for (int i = 0; i < arr.length; i++) {
            if (cur[i] >= 0){
                min = i;
                System.out.println("-------");
                System.out.println(cur[i]);
                System.out.println("-------");
                x=1;
            }
            // System.out.println(cur[i]);
        }
        if(x==0) {
            return memo[sum] = -1;
        }*/
        // System.out.println("-------");
        
    }

    public static void main(String[] args) {
        
        /*int[] arr = {1,5,7}; 
        int n = 18;*/

        int[] arr = {186,419,83,408}; 
        int n = 6249;
        
        /*int[] arr = { 10,2,5 }; 
        int n = 10; */

        /*int[] arr = { 2 };
        int n = 3;*/
        int[] memo = new int[n + 1];
        int minCount = countSum(arr, n, memo);
        System.out.println("=======");
        System.out.println(minCount);
        System.out.println("=======");
        //for(int x : memo){ System.out.println(x); }
    }
}
