import java.util.*;

public class arrayRotation2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int[] sw = new int[arr.length-l];

        for(int i=0;i<sw.length;i++){
            sw[i] = arr[l+i];
        }

        for (int i = arr.length-1; i >= f + sw.length; i--) {
            arr[i] = arr[i-sw.length];
        }

        for(int i = f;i < f+sw.length;i++){
            arr[i] = sw[i-f];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
