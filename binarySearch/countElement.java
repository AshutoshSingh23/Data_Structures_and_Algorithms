package binarySearch;

public class countElement {
    
    public static int largestCount(int[] arr, int m) {
        int n = arr.length;
        int s = 0, mid = n / 2, f = n - 1, ans = 0;

        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] == m) {
                ans++;
                f = mid - 1;
            } else if (arr[mid] > m)
                f = mid - 1;
            else
                s = mid + 1;
        }

        s = 0;
        mid = n/2 ;
        f = n-1; 

        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] == m) {
                ans++;
                s = mid + 1;
            } else if (arr[mid] > m)
                f = mid - 1;
            else
                s = mid + 1;
        }
        return --ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 10, 10, 12, 12, 13, 14 };
        int m = 1;
        System.out.println(largestCount(arr, m));
    }
}
