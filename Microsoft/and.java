package Microsoft;

public class and {


    public static int solve(int[] A, int i, int len, int and){
        if(i<0)
            return 0;
        if(and == 0){
            return -1;
        }
        int ans = 0;
        
        int a = solve(A,i-1,len,and);
        int f = and&A[i];
        int b = solve(A,i-1,len,f);
        if(a!=-1)
            ans = Math.max(a+1,ans);
        if(b!=-1)
            ans = Math.max(b+1,ans);
        if(ans == 0)
            return -1;
            System.out.println(i + " " + and + " " + ans + " " + a + " " + b + " " + f);
        return ans;
    }
    
    public static void main(String[] args){
        //int arr[] = {13,7,2,8,3};

        int arr[] = {1,2,4,8};
        int base=0;
        for(int i=0;i<32;i++){
            base = base << 1;
            base = base|1;
        }
        int res = Math.max(1,solve(arr,arr.length-1,0,base));
        System.out.println(res);
    } 
}
