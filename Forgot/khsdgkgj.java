import java.math.BigInteger;

public class khsdgkgj {

    public static int count(BigInteger n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");

        if (n.equals(b))
            return 0;

        if (n.and(b).equals(a))
            return count(n.shiftRight(1)) + 1;

        int x, y;
        x = count((n.add(b)).shiftRight(1));
        y = count((n.subtract(b)).shiftRight(1));
        if (x > y)
            return y + 2;
        return x + 2;
    }

    public static int solution(String s) {
        BigInteger n = new BigInteger(s);
        return count(n);
    }
    
}
