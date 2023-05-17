package binarySearch;

public class peakElement {

    public static int peakEle(int[] arr) {
        int s = 0, mid, f = arr.length;
        while (s <= f) {
            mid = s + (f - s) / 2;
            if(mid>0&&mid<arr.length){
                if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
                    return mid;
                else if(arr[mid-1]>arr[mid+1])
                    f = mid - 1;
                else 
                    s = mid + 1;
            }else if(mid == 0){
                if(arr[0]>arr[1])
                    return 0;
            }else{
                if(arr[arr.length-1]>arr[arr.length-2])
                    return arr.length;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5,10,20,15 };
        System.out.println(peakEle(arr));
    }
    
}
