package slidingWindow;

public class largestSubarraySumK {

    public static int slide(int k, int[] arr) {
        int i, j, count,sum;
        i = j = count = 0;
        sum = arr[j];
        while(j<arr.length){
            if(sum<k){
                j++;
                if(j>=arr.length)
                    break;
                sum+=arr[j];
                continue;
            }
            if(sum==k){
                count = Math.max(count,j-i+1);
                System.out.println(i+" "+j);
            }
            sum-=arr[i];
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 4,1,1,1,2,3,5,6 };
        int k = 5;
        System.out.println(slide(k, arr));
    }
    
}
