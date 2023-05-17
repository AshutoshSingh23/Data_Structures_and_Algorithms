import java.util.*;

public class squarePanel {

    public static double invSqrt(double x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        x = Double.longBitsToDouble(i);
        x *= (1.5d - xhalf * x * x);
        return x;
    }
    
    public static boolean checkIfSquare(int n){
        return (Math.sqrt((double)n)-Math.floor(Math.sqrt((double)n))==0); 
    }
    public static int[] solution(int area){
        int m = area, c = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (m > 0) {
            if (checkIfSquare(m)) {
                list.add(m);
                m = c;
                c = 0;
                continue;
            }
            m = m - 1;
            c++;
        }
        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        System.out.println(list);
        System.out.println();
        return nums;
    }
    public static int maxSquare(int n){
        return (int) Math.pow(Math.floor(Math.sqrt((double) n)), 2);
    }

    public static int[] answer(int n){
        int m = n, c = 0;
        ArrayList<Integer> list = new ArrayList<>();

        if (checkIfSquare(n)) {
            int[] nums = new int[1];
            nums[0] = n;
            return nums;
        }

        while (m > 0) {
            c = maxSquare(m);
            list.add(c);
            m -= c;
        }
        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        System.out.println(list);
        System.out.println();
        return nums; 
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] nums = answer(n);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        /*int m = n, c = 0;
        ArrayList<Integer> alist = new ArrayList<>();
        while (m > 0) {
            if (checkIfSquare(m)) {
                alist.add(m);
                m = c;
                c = 0;
                continue;
            }
            m = m - 1;
            c++;
        }
        int[] nums = new int[alist.size()];
        for (int i = 0; i < alist.size(); i++) {
            nums[i] = alist.get(i);
        }
        for (int i = 0; i < alist.size(); i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        */
    }
}
