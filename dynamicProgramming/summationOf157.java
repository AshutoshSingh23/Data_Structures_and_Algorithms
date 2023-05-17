package dynamicProgramming;

public class summationOf157 {

    public static int countSum(int[] arr, int sum){
        int count = 1;
        int[] cur= new int[arr.length];
        if(sum == 0) {
            return 0;
        }
        if(sum<0) return Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            cur[i] = countSum(arr,sum-arr[i]);
        }
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if(cur[i]<cur[min]) min=i;
        }
        count += cur[min];
        return count;
    }
    public static void main(String[] args){
        int[] arr = { 186, 419, 83, 408};
        int n = 6249;
        int minCount = countSum(arr, n);
        System.out.println(minCount);
    }
}
