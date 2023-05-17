package dynamicProgramming;

public class mcm {

    static int[][] memo = new int[1001][1001];

    public static int recurmCM(int[] ar, int i, int j){
        if(i>=j)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = recurmCM(ar,i,k) + recurmCM(ar,k+1,j) + ar[i-1]*ar[k]*ar[j];
            min = Math.min(min,temp);
        }
        return min;
    }

    public static int memomCM(int[] ar, int i, int j) {
        if (i >= j)
            return 0;
        if(memo[i][j]!=0)
            return memo[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = memomCM(ar, i, k) + memomCM(ar, k + 1, j) + ar[i - 1] * ar[k] * ar[j];
            min = Math.min(min, temp);
        }
        return memo[i][j] = min;
    }

    public static void main(String[] args) {
        int[] ar = { 20,10,30,40 };
        System.out.println(memomCM(ar,1,ar.length-1));
        
    }
}
