package binarySearch;

public class floorElementSortedArray {
    public static int floor(int[] arr, int m) {
        int n = arr.length;
        int ans=0,s = 0, mid = n / 2, f = n - 1;
        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] <= m){
                if(arr[ans]<arr[mid])
                    ans = mid;
                s = mid + 1;
            }
            else if (arr[mid] > m)
                f = mid - 1;
        }
        return ans;
    }

    public static int ceil(int[] arr, int m) {
        int n = arr.length;
        int ans = 0, s = 0, mid = n / 2, f = n - 1;
        while (s <= f) {
            mid = s + (f - s) / 2;
            if (arr[mid] >= m) {
                return mid;
                
            } else if (arr[mid] < m)
                s = mid + 1;
            else{
                ans = arr[mid];
                f = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7, 8, 12, 20, 23, 44 };
        int m = 6;
        System.out.println(ceil(arr, m));
    }
}
