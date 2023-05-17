package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class speedEfficiency {

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineer = new int[n][2];
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            engineer[i] = new int[] { speed[i], efficiency[i] };
        }
        Arrays.sort(engineer, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (int[] engi : engineer) {
            if (k == pq.size())
                sum -= pq.poll();
            sum += engi[0];
            pq.add(engi[0]);
            max = Math.max(max, (engi[1] * sum));
        }
        return (int) (max % mod);
    }

    public static int recurApproach(int[] s, int sum, int i, int k,int[] e, Set<Integer> set){
        int min = Integer.MAX_VALUE;
        if(set.isEmpty()&&i>=0)
            min = e[i];
        else{ 
            for(int j=0;j<e.length;j++){
                if(min>e[j]&&set.contains(j))
                    min = e[j];
            }
        }
        if(k<=0||i<0){
            if(set.isEmpty())
                return 0;
            return sum*min;
        }
        Set<Integer> set1 = new HashSet<>();
        set1.addAll(set);
        set1.add(i);
        return Math.max(recurApproach(s,sum+s[i],i-1,k-1,e,set1),recurApproach(s, sum, i-1, k, e, set));
    }

   
    public static void main(String[] args){
        int[] speed = {2,10,3,1,5,8};
        int[] effi = {5,4,3,9,7,2};
        int k = 2;
        Set<Integer> set = new HashSet<>();
        System.out.println(recurApproach(speed, 0, speed.length-1, k, effi, set));
    }
    
}
