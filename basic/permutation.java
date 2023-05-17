import java.util.*;
public class permutation{

    static ArrayList<int[]> list = new ArrayList<int[]>(); 

    public static void printarray(int[] arr){
        System.out.println("=========");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("=========");
    }
    
    public static void permut(int[] arr, int l, ArrayList<int[]> alist){
        int sw;
        if(l==arr.length-1){
            printarray(arr);
            alist.add(arr);
            list.add(arr);
            return;
        }
        for(int i=l;i<arr.length;i++){
            sw = arr[i];
            arr[i] = arr[l];
            arr[l] = sw;

            permut(arr,l+1,alist);

            sw = arr[l];
            arr[l] = arr[i];
            arr[i] = sw;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println();

        ArrayList<int[]> alist = new ArrayList<int[]>();

        permut(arr, 0, alist);

        for(int[] e : alist){
            for(int i=0;i<n;i++){
                System.out.print(e[i]+" ");
            }
            System.out.println();
        }
        System.out.println(list.size());
        sc.close();
    }
}