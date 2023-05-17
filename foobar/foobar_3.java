import java.util.Scanner;

public class foobar_3 {
    public static int[] solution(int[] pegs) {
        int[] ans = { -1, -1 };
        int sum = 0;
        for (int i = 1; i < pegs.length; i++) {
            if (i % 2 == 0) {
                sum -= pegs[i] - pegs[i - 1];
            } else {
                sum += pegs[i] - pegs[i - 1];
            }
        }
        int r = 2*sum;
        if(pegs.length%2==0){
            if(r/3<1) return ans;
            if(r%3==0){
                ans[0] = r/3;
                ans[1] = 1;
            }else{
                ans[0] = r;
                ans[1] = 3;
            }
        }else{
            if(r<1) return ans;
            ans[0] = r;
            ans[1] = 1;
        }
        double l = ans[0]/ans[1];
        for (int i = 1; i < pegs.length; i++) {
            int d = pegs[i] - pegs[i-1];
            if(l>=d){
                ans[0] = ans[1] = -1;
                break;
            }
            l = d-l;
        }
        return ans;        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++)
            nums[i] = sc.nextInt();

        sc.close();
        int[] s = solution(nums);
        System.out.println();
        System.out.println(s[0] + " " + s[1]);
        System.out.println();

    }
}
