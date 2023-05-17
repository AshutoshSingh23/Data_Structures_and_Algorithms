package dynamicProgramming;

public class summationOf135 {

    static int count = 0;
    public static void countSum(int[] arr, int sum){
        if(sum == 0) {
            count++;
            return;
        }
        if(sum<0) return;
        for(int i=0;i<arr.length;i++){
            countSum(arr,sum-arr[i]);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,3,5};
        int n = 10;
        countSum(arr, n);
        System.out.println(count);
    }
}
