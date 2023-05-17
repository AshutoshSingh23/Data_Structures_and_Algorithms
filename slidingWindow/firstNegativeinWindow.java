package slidingWindow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class firstNegativeinWindow {

    public static List<Integer> firstNegative(int k, int[] arr) {
        int i, j;
        i = j = 0;
        List<Integer> list = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        while (j < arr.length) {
            if (j - i + 1 != k) {
                if(arr[j]<0){
                    q.add(arr[j]);
                }
                j++;
                continue;
            } 
            if(q.isEmpty()){
                list.add(0);
                i++;
                j++;
                continue;
            }
            if(arr[i] == q.peek()){
                list.add(q.poll());
            }else{
                list.add(q.peek());
            }
            if(arr[j]<0)    
                q.add(arr[j]);
            i++;
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -2, 7, -1, -8, 4, 5, 6 };
        int k = 3;
        List<Integer> lis = firstNegative(k, arr);
        for(int i : lis)
            System.out.print(i+" ");
        System.out.println();
    }
    
}
