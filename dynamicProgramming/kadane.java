package dynamicProgramming;

public class kadane {

    public static void main(String[] args){
        int[] arr = {1,-2,5,4,9,-5,2,3,6,7,-1};
        int ans = Integer.MIN_VALUE;
        ans = arr[0];
        int a = ans;
        for(int i=1;i<arr.length;i++){
            a+=arr[i];
            a = Math.max(arr[i],a);
            ans = Math.max(ans,a);
        }
        System.out.println(ans);
    }
    
}
