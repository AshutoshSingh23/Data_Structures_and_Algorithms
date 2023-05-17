import java.util.*;

public class teat {
    static int max(int[] arr, int l) {
        int max = l;
        for (int i = l; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    static int[] per(int[] arr, int k, int l) {
        if (k == 0) {
            return arr;
        }
        int max = max(arr, l);
        if (max == l) {
            l++;
            if (l >= arr.length)
                return arr;
            max = max(arr, l);
        }
        int sw = arr[l];
        arr[l] = arr[max];
        arr[max] = sw;
        k--;
        if (l + 1 >= arr.length)
            return arr;
        return per(arr, k, l + 1);
    }

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
        if (k >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= -1;
            }
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= -1;
            }
            return arr;
        }
        return per(arr, k, 0);
    }

    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        printArray(per(arr, k, 0));
    }
}
