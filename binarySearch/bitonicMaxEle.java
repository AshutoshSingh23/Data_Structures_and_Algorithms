package binarySearch;

public class bitonicMaxEle {

    public static int maxEle(int[] arr){
        int s = 0, f = arr.length-1;
        while(s<=f){
            int mid = s + (f - s)/2;
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){
                return arr[mid];
            }else if(arr[mid+1]>arr[mid-1]){
                s = mid + 1;
            }else{
                f = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 15, 12, 10, 4};
        System.out.println(maxEle(arr));
    }
    
}
