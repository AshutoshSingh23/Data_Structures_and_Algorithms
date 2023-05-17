import java.math.BigInteger;
import java.util.Scanner;

public class KickStart {
    public static void main(String[] args){
        int n,k,t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        long mod = (long) (1e9 + 1);
        int q = 0;
        while(q<t){
            n = sc.nextInt();
            k = sc.nextInt();
            String s  = sc.nextLine();
            int mid = (n-1)/2;
            BigInteger big = new BigInteger("0");
            for(int i = 0;i<n;i++){
                int hierarchy = s.charAt(i)-'a';
                int alte = mid - i ;
                BigInteger K = new BigInteger(Integer.toString(k));
                
                BigInteger alt = new BigInteger(Integer.toString(alte));
                
            }
        }
        

    }
}
