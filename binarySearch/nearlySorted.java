package binarySearch;

public class nearlySorted {
    
    public static int binSearch(int[] arr, int m) {
        int n = arr.length;
        int s = 0, mid = n / 2, f = n - 1;
        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] == m)
                return mid;
            else if(mid-1>=s&&arr[mid]==m)
                return mid-1;
            else if(mid+1<=f&&arr[mid+1] == m)
                return mid+1;
            else if(arr[mid] > m)
                f = mid - 2;
            else
                s = mid + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 6, 5, 13, 10, 25, 23, 40 };
        int m = 5;
        System.out.println(binSearch(arr, m));
    }

}
