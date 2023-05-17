import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class sum3Equalto0 {

    public static int[][] threeSum2(int[] arr) {
        Arrays.sort(arr);
        List<int[]> list = new LinkedList<>();
        Set<int[]> set = new HashSet<>();
        int s, f;
        for (int i = 0; i < arr.length; i++) {
            int[] nums = new int[3];
            nums[0] = arr[i];
            int tar = -arr[i];
            s = i + 1;
            f = arr.length - 1;
            while (s < f) {
                int k = arr[s] + arr[f];
                if (tar == k) {
                    nums[1] = arr[s];
                    nums[2] = arr[f];
                    Arrays.sort(nums);
                    System.out.println(" qweqweqwe      " + tar + "            " + k +"      "+ nums[0] +"     "+ nums[1] +"        "+ nums[2]);
                    set.add(nums);
                    s++;
                    f--;
                } else if (tar > k) {
                    s++;
                } else {
                    /*for (int[] x : set) {
                        System.out.print(x[0] + " " + x[1] + " " + x[2] + "   " + i);
                        System.out.println();
                    }*/
                    f--;
                }
            }
        }
        // for(int[] x:list)
        // set.add(x);
        int[][] res = new int[set.size()][3];
        int k = 0;
        for (int[] x : set) {
            System.out.print(x[0] + " " + x[1] + " " + x[2]);
            System.out.println();
            res[k][0] = x[0];
            res[k][1] = x[1];
            res[k][2] = x[2];
            k++;
        }
        return res;
    }



    public static int[][] threeSum(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();
        int s, f;
        int[] nums = new int[3];
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            num.add(arr[i]);
            int tar = -arr[i];
            s = i + 1;
            f = arr.length - 1;
            while (s < f) {
                int k = arr[s] + arr[f];
                if (tar == k) {
                    num.add(arr[s]);
                    num.add(arr[f]);
                    Collections.sort(num);
                    System.out.println(num.get(0)+" "+num.get(1)+" "+num.get(2));
                    if(num.size()==3)   set.add(num);
                    num.clear();
                    num.add(arr[i]);
                    for (List<Integer> x : set) {
                        System.out.println("**************************"+x.get(0) + " " + x.get(1) + " " + x.get(2));
                    }
                    s++;
                } else if (tar > k) {
                    s++;
                } else {
                    f--;
                }
            }
            num.clear();
        }
        int[][] res = new int[set.size()][3];
        int k = 0;
        for (List<Integer> x : set) {
            System.out.println("**************************" + x.get(0) + " " + x.get(1) + " " + x.get(2));
            res[k][0] = x.get(0);
            res[k][1] = x.get(1);
            res[k][2] = x.get(2);
            k++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
        int[][] res = threeSum2(arr);
        /*for(int[] x:res){
            for(int y:x)
                System.out.print(y+" ");
            System.out.println();
        }*/
    }
    
}
