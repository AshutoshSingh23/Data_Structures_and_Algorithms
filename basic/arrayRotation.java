import java.util.*;

public class arrayRotation {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        

        int sw = arr[l];
        for(int i=l;i>f;i--){
            arr[i] = arr[i-1];
        }
        
        arr[f] = sw;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
