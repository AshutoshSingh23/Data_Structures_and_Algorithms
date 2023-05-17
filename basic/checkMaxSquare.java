import java.util.*;

public class checkMaxSquare {

    public static int maxSquare(int n){
        return (int)Math.pow(Math.floor(Math.sqrt((double) n)), 2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(maxSquare(n));
    }
}
