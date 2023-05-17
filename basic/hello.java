public class hello{

    public static int solution(String s) {
        long a = Long.parseLong(s);
        int count = 0;
        while (a > 1) {
            long b = (a + 1) & a;
            long c = a & 1;
            if (b == 0) {
                a = a + 1;
                count++;
                continue;
            }
            if (c == 1) {
                a = a - 1;
            } else {
                a = a >> 1;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println("hello");
    }
}