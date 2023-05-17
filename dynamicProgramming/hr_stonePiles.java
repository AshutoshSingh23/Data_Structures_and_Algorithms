package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class hr_stonePiles {

    public static boolean check(long n, List<Long> s) {
        for (int i = 0; i < s.size(); i++) {
            long c = s.get(i);
            if (c != n && n % c == 0)
                return true;
        }
        return false;
    }

    // f=1
    public static long maxCount(long n, List<Long> s, long f) {
        if (!check(n, s)) {
            System.out.println("-++-" + n + "-++-");
            return 0;
        }
        long count = 1;
        long max = (long) Integer.MIN_VALUE;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) != n && n % s.get(i) == 0) {
                System.out.println(n + "=========" + s.get(i) + " ===== " + f);
                f = n / s.get(i);
                max = Math.max(max, maxCount(s.get(i), s, f));
            }
        }
        if (max == (long) Integer.MIN_VALUE) {
            return 0;
        }
        count += f * max;
        System.out.println("----" + count + "-----");
        return count;
    }

    public static long stoneDivision(long n, long[] s) {
        List<Long> list = new ArrayList<>();
        for(long i : s)
            list.add(i);
        System.out.println();
        return maxCount(n, list, 1);

    }

    public static void main(String[] args) {
        long[] arr = { 1,2,3,4,8};
        long n = 24;
        
        System.out.println(stoneDivision(n, arr));
        System.out.println(Long.MAX_VALUE);
        
    }
}
