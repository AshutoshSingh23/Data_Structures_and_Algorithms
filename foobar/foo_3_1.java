import java.util.Scanner;

public class foo_3_1 {

    public static int powerof2(int n) {
        int t = 0;
        while (n > 0) {
            n = n >> 1;
            t++;
        }
        return t - 1;
    }

    public static int solution(int a, int[] memo) {
        if (a == 1)
            return 0;
        if (memo[a] != 0)
            return memo[a];
        int count = 1;
        int[] cur = new int[2];
        int b = a & (a - 1);
        if (b == 0) {
            count += powerof2(a)-1;
            memo[a] = count;
            return count;
        }
        int c = a & 1;
        if (c == 0) {
            count += solution(a / 2, memo);
        } else {
            cur[0] = solution(a - 1, memo);
            cur[1] = solution(a + 1, memo);
        }
        if (cur[0] < cur[1]) {
            count += cur[0];
        } else {
            count += cur[1];
        }
        memo[a] = count;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = Integer.parseInt(s);
        int[] memo = new int[a + 2];
        sc.close();
        int num = solution(a, memo);
        System.out.println(num);

    }
}