import java.util.ArrayList;
import java.util.List;

public class smallAfterSelf {

    public static void merge(int[] arr,int s,int mid,int f){
        int[] a = new int[mid-s+1];
        int[] b = new int[f - mid];
        int p = 0;
        while(p<a.length){
            a[p] = arr[s+p];
            p++;
        }
        p=0;
        while(p<b.length){
            b[p] = arr[mid+1+p];
            p++;
        }
        p=s;
        int i=0,j=0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]&&i<=mid+1){
                arr[p] = a[i];
                i++;
            }else{
                arr[p] = b[j];
                j++;
            }
            p++;
        }
        while(i<a.length){
            arr[p] = a[i];
            i++;p++;
        }
        while(j<b.length){
            arr[p] = b[j];
            j++;p++;
        }
        return;
    } 

    public static int[] mergeSort(int[] nums, int s, int f, int[] count){
        if(s>=f)
            return count;
        int mid = s + (f-s)/2;
        mergeSort(nums, s, mid, count);
        mergeSort(nums, mid+1, f, count);
        merge(nums,s,mid,f);
        return count;
    } 
    
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums.length <= 1) {
            list.add(0);
            return list;
        }
        int[] count = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, count);
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:count)
            list.add(i);
        return list;
    }


    public static void main(String[] args){
        int[] arr = {4,2,6,9,8,7,1,9};
        List<Integer> list = countSmaller(arr);
        for(int x:list)
            System.out.println(x);
    }
}
