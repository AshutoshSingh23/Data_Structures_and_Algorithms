public class Solution {
    
    public static int maxSquare(int n){
        return (int) Math.pow(Math.floor(Math.sqrt((double) n)), 2);
    }
    
    public static double invSqrt(double x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        x = Double.longBitsToDouble(i);
        x *= (1.5d - xhalf * x * x);
        return x;
    }

    public static int[] solution(int n){
        int m = n, c = 0;
        List<Integer> list = new ArrayList<>();

        while (m > 0) {
            c = (int) Math.pow(Math.floor(invSqrt((double) m))), 2);
            list.add(c);
            m -= c;
        }
        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums; 
    }
}