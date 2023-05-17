package binarySearch;

public class allocateBooks {

    public static boolean isValid(int[] arr, int k, int max){
        int stu = 1, sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max){
                stu++;
                sum = arr[i];
            }
            if(stu>k)
                return false;
        }
        return true;
    }

    public static int minBooks(int[] arr, int k){
        if(k>arr.length) 
            return -1;
        int max = Integer.MIN_VALUE, ans = -1, sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(max<arr[i])
                max = arr[i];
            sum += arr[i];
        }
        int s = max, f = sum;
        while(s<=f){
            int mid = s + (f-s)/2;
            if(isValid(arr, k, mid)){
                f = mid-1;
                ans = mid;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,10,20,36};
        int k = 2;
        System.out.println(minBooks(arr,k));
    }
    
}
