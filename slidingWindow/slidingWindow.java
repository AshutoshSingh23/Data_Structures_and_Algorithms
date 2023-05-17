package slidingWindow;

public class slidingWindow {

    public static int slide(int k, int[] arr){
        int i,j,sum,max=Integer.MIN_VALUE;
        i = j = sum = 0;
        while(j<arr.length){
            if(j-i+1!=k){
                sum += arr[j];
                System.out.println(sum + " " + arr[j]);
                j++;
                continue;
            }else{
                sum += arr[j];
            }
            max = Math.max(sum, max);
            sum -= arr[i];
            i++;
            j++;
        }

        return max;
    }

    public static void main(String[] args){
        int[] arr = {2,3,7,1,8,4,5,6};
        int k = 3;
        System.out.println(slide(k, arr));
    }
    
}
