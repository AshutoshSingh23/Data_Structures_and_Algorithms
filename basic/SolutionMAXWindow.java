import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class SolutionMAXWindow {

    public static List<Integer> maxWin(int k, int[] arr) {
        int i, j, max = Integer.MIN_VALUE;
        i = j = 0;
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>();
        max = Math.max(max, arr[j]);
        System.out.println(max + " " + arr[j]);
        Pair op = new Pair(max);
        q.add(op);
        while (j < arr.length) {
            if (j - i + 1 != k) {
                j++;
                max = Math.max(max, arr[j]);
                if (max != q.peek().val)
                    q.clear();
                Pair pa = new Pair(arr[j]);
                q.add(pa);
                System.out.println(max + " " + arr[j]);
                continue;
            }
            list.add(max);
            j++;
            if (j >= arr.length)
                break;
            max = Math.max(max, arr[j]);
            if (max != q.peek().val)
                q.clear();
            Pair pa = new Pair(arr[j]);
            q.add(pa);

            if (arr[i] == max) {
                q.poll();
                max = q.peek().val;
            }
            System.out.println(max + " | " + arr[j]);
            i++;
        }
        return list;
    }

    static class Pair implements Comparable<Pair> {

        int val;

        Pair(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - this.val;
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> lis = maxWin(k, nums);
        int[] arr = new int[lis.size()];
        for (int i = 0; i < lis.size(); i++)
            arr[i] = lis.get(i);
        return arr;
    }
}