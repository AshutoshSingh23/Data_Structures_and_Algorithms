package binarySearch;

public class minDifference {

    public static int minDiff(int[] arr,int m){
        int s=0,mid,f= arr.length;
        while(s<=f){
            mid = s+(f-s)/2;
            if(arr[mid] == m)
                return arr[mid];
            else if(arr[mid]<m)
                s = mid + 1;
            else
                f = mid - 1;
        }
        if(Math.abs(m-arr[f])>Math.abs(m-arr[s]))
            return arr[s];
        else
            return arr[f];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 8, 12, 20, 23, 44 };
        int m = 7;
        System.out.println(minDiff(arr, m));
    }
    
}
