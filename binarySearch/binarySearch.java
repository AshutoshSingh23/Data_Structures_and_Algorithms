package binarySearch;

public class binarySearch {

    public static int binSearch(int[] arr, int m){
        int n = arr.length;
        int s=0,mid = n/2,f=n-1;
        /*while(mid<n&&mid>=0){
            if(arr[s] == m)
                return s;
            if(arr[f] == m)
                return f; 
            if(arr[mid] == m)
                return mid;
            else if(arr[mid]>m){
                f = mid;
                mid = (mid-s)/2;
            }else{
                s = mid;
                mid += (f-mid)/2; 
            }
        }*/
        while(s<=f){
            //mid = (s+f)/2;
            mid = s + (f-s)/2;
            if(arr[mid] == m)
                return mid;
            else if(arr[mid]>m)
                f = mid-1;
            else
                s = mid+1;
        }  
        return -1;
    } 
    public static void main(String[] args){
        int[] arr ={1,2,4,5,6,8,12,20,23,44};
        int m = 8;
        System.out.println(binSearch(arr,m));
    } 
}
