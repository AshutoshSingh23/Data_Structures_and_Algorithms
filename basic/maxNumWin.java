import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class maxNumWin {
    

    public static List<Integer> maxWin(int k, int[] arr) {
        int i,j,max = Integer.MIN_VALUE;
        i = j = 0;
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); //use priority queue
        max = Math.max(max, arr[j]);
        System.out.println(max + " " + arr[j]);
        q.add(max);
        while (j < arr.length) {
            if (j - i + 1 != k) {
                j++;
                max = Math.max(max,arr[j]);
                if(max!=q.peek())
                    q.clear();
                q.add(arr[j]);
                System.out.println(max + " " + arr[j]);
                continue;
            }
            list.add(max);
            j++;
            if(j>=arr.length)
                break;
            max = Math.max(max,arr[j]);
            if (max != q.peek())
                q.clear();
            q.add(arr[j]);
            
            if(arr[i] == max){
                q.poll();
                max = q.peek();
            }
            System.out.println(max + " | " + arr[j]);
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 7,2,4};
        int k = 3;
        List<Integer> lis = maxWin(k, arr);
        for (int i : lis)
            System.out.print(i + " ");
        System.out.println();
    }
}
