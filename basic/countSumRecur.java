public class countSumRecur{

    static int count = 0;
    
    public static void countSum(int[] arr, int sum, int l) {
        if (sum == 0) {
            count++;
            return;
        }
        if (sum < 0)
            return;
        for (int i = l; i < arr.length; i++) {
            if(arr[i] > sum) return;
            countSum(arr, sum - arr[i],l+1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6 };
        int n = 10;
        countSum(arr, n, 0);
        System.out.println(count);
    }
}
