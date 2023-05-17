import java.util.Scanner;

public class bitmanipulation {

    public static boolean powerOf2(int a){
        System.out.println(a&(~a));
        int b = a&(a-1);
        if(b==0) {  
            return true;
        }
        return false;
    }

    public static void timepass(){
        int x = 1;
        x = ~x;
        System.out.println(x);
        x = ~x;
        System.out.println(x);
        x = ~x;
        System.out.println(x);
        x = ~x;
        System.out.println(x);
    }
    public static void main(String[] args){
        int m;
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        sc.close();
        timepass();
        System.out.println(m);
    }
}
