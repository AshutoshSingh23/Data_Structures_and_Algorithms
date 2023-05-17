package dynamicProgramming;

import java.util.Scanner;
import java.util.*;

public class new1 {

    public static int maxSquare(int n) {
        int u = (int) Math.floor(Math.sqrt((double) n));
        return u * u;
    }

    public static int[] solution(int n) {
        int c;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            c = maxSquare(n);
            n = n - c;
            list.add(c);
        }
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] arr = solution(n);
        for(int i:arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
