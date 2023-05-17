package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class dp_hr_coinchange {
    static long count = 0;

    public static void count1(long n, List<Long> c, int s, boolean[][] memo) {
        if (n == 0) {
            count++;
            memo[s][(int) n] = true;
            return;
        }
        if (n < 0)
            return;
        if (memo[s][(int) n] == true) {
            count++;
        }
        for (int i = s; i < c.size(); i++) {
            count1(n - c.get(i), c, i, memo);
        }
    }

    public static long getWays(int n, List<Long> c) {
        boolean[][] memo = new boolean[c.size()][n + 1];
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < n + 1; j++) {
                memo[i][j] = false;
            }
        }
        count1(n, c, 0, memo);
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        ArrayList<Long> list = new ArrayList<>();
        list.add((long)1);
        list.add((long)3);
        list.add((long)5);
        long l = getWays(n, list);
        System.out.println(l);
    }
}
