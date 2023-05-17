package binarySearch;

public class elementRotatedArray {

    public static int findNumber(int[] arr, int m, int min) {
        int n = arr.length;
        int s = 1, mid = min / 2, f = min - 1;
        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] == m)
                return mid;
            else if (arr[mid] > m)
                f = mid - 1;
            else
                s = mid + 1;
        }
        s = min;
        f = n-1;
        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] == m)
                return mid;
            else if (arr[mid] > m)
                f = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }

    public static int noOFRotation(int[] arr) {
        int n = arr.length;
        int s = 1, mid = n / 2, f = n - 1;
        while (s <= f) {
            mid = s + (f - s) / 2;
            int prev = (mid + n - 1) % n, next = (mid + n + 1) % n;
            if (arr[mid] < arr[next] && arr[mid] < arr[prev])
                return mid;
            if (arr[mid] <= arr[f])
                f = mid - 1;
            else if (arr[mid] >= arr[s])
                s = mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 9, 10, 1, 2, 3, 4, 5, 6 };
        int min = noOFRotation(arr);
        System.out.println(findNumber(arr,42,min));
    }
    
}
