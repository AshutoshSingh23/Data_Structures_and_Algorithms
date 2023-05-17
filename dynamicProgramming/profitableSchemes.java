package dynamicProgramming;

public class profitableSchemes {
    public static long maxWays(int n, int m, int[] grp, int[] pf, int i) {
        
        if (n == 0) {
            if (m <= 0) {
                System.out.println("+++++++++++++++++++++++++++++++++++++++" + m + " " + i);
                return 1;
            } else{
                System.out.println("-----------------------------------------------");
                return 0;
            }
        }
        if (n < 0){
            System.out.println("qwertyuiop[pupeqi");
            return 0;
        }
        if (n > 0 && m <= 0){
            if(i<0)
                return 1;
            long k =  1 + maxWays(n - grp[i], m - pf[i], grp, pf, i - 1);
            System.out.println(k+"  //////////////////////////  " + i +" /*/*/*/*/ ");
            return k;
        }

        if (i < 0) {
            System.out.println("|||||||||||||||||||||||||||||||  " + i);
            return 0;
        }
        long k = maxWays(n - grp[i], m - pf[i], grp, pf, i - 1) + maxWays(n, m, grp, pf, i - 1);
        System.out.println(k + " ugsrfgGH "+ i);
        return k;
    }

    public static int profitSchemes(int n, int minProfit, int[] group, int[] profit) {
        long x = maxWays(n, minProfit, group, profit, group.length - 1) % 1000000007;
        return (int) x;
    }

    public static void main(String[] args){
        int n = 5, m = 3;
        int[] grp = {2,2};
        int[] pf = {2,3}; 
        System.out.println(profitSchemes(n,m,grp,pf));
    }
}
