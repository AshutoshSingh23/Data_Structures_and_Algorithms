import java.util.Arrays;

public class longestConsecutive {
    public static int longestConsec(int[] a) {
        Arrays.sort(a);
        int count = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] == a[i] + 1) {
                count++;
                System.out.println(a[i]+"   ///////////////  " + count);
            }else if(a[i]==a[i+1]){
                continue;
            }else{
                count = 0;
                System.out.println(a[i]+"   *****************   "+max);
            }
            System.out.println(count+"    |||||    "+max);
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {1,2,0,1};
        System.out.println(longestConsec(arr));
    }
}
