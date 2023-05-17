package binarySearch;

public class bitonicSearchEle {

    public static int maxEle(int[] arr) {
        int s = 0, f = arr.length - 1;
        while (s <= f) {
            int mid = s + (f - s) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid + 1] > arr[mid - 1]) {
                s = mid + 1;
            } else {
                f = mid - 1;
            }
        }
        return -1;
    }

    public static int binSearch(int[] arr, int m, int s, int f) {
        while (s <= f) {
            int mid = s + (f - s) / 2;
            if (arr[mid] == m)
                return mid;
            else if (arr[mid] < m)
                s = mid + 1;
            else
                f = mid - 1;
        }
        return -1;
    }

    public static int revbinSearch(int[] arr, int m, int s, int f) {
        while (s <= f) {
            int mid = s + (f - s) / 2;
            if (arr[mid] == m)
                return mid;
            else if (arr[mid] > m)
                s = mid + 1;
            else
                f = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 15, 12, 10, 4 };
        int m = 12,i;
        int max = maxEle(arr);
        
        if(m == arr[max])
            i = max;
        else{ 
            i = binSearch(arr, m, 0, max-1);
            if(i == -1)
            i = revbinSearch(arr, m, max, arr.length-1);
        }
            
        System.out.println(i);
    }
    
}
