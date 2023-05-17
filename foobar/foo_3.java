import java.math.BigInteger;
import java.util.Scanner;

public class foo_3 {
    public static int count(BigInteger n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        int count = 0;
        while (!n.equals(b)) {
            BigInteger x = n.add(b);
            BigInteger y = n.subtract(b);
            BigInteger z = y.subtract(b);

            x = n.and(x);
            y = y.and(z);

            if (n.and(b).equals(a)) {
                n = n.shiftRight(1);
            } else {
                if (n.equals(b.add(b).add(b)) || x.compareTo(y) == 1) {
                    n = n.subtract(b);
                } else {
                    n = n.add(b);
                }
            }
            count++;
        }
        return count;
    }

    public static int solution(String s) {
        BigInteger n = new BigInteger(s);
        return count(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int num = solution(s);
        System.out.println(num);

    }
}