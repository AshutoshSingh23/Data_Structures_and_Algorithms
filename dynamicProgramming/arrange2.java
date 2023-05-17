package dynamicProgramming;

public class arrange2 {

    static int[][] memo;

    public static int partition(String s, int part, int j, int w, int b) {
        //if (j == 0&&part==0){
            //System.out.println(j + " " + part);
            //return 0;
        //}
        if(j==0){
            //System.out.println(j + " " + part);
            return 0;
        }
        int w1 = 0, b1 = 0;
        if (part == 0) {
            return b * w;
        }
        //if (memo[j][part] != -1)
            //return memo[j][part];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < j; k++) {
            if (s.charAt(k) == 'W')
                w1++;
            else
                b1++;
            int c=0;
            if(memo[k][part-1]!=-1)
                c = memo[k][part-1];
            else 
                c = partition(s, part - 1, k, w1, b1);
            //System.out.println(c);
            if(c>=0)
                min = Math.min(min, c + (w - w1) * (b - b1));
        }
        if(min == Integer.MAX_VALUE){
            //System.out.println(j + " " + part);
            return -1;
        }
        return memo[j][part] = min;
    }

    public static int arrange(String s, int k) {
        if (k > s.length())
            return -1;
        int w = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'W')
                w++;
            else
                b++;
        }
        memo = new int[s.length()][k];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<k;j++)
                memo[i][j] = -1;
        }
        return partition(s, k - 1, s.length() - 1, w, b);
    }

    public static void main(String[] args) {
        String s = "BWWWWBBWWBWBWWBBBBBWBWWBBBWWWWBBBW";
        //String s = "WWWB";
        int k = 28;
        System.out.println(arrange(s,k));

        //System.out.println();
    }

}