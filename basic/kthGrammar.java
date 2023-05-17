public class kthGrammar {

    public static int kGrammar(int n,int k){
        if(n==1||k==1)
            return 0;
        int p = (int) Math.pow(2,n);
        int mid = p/2;
        if(k<=mid)
            return kGrammar(n-1, k);
        else{
            if(kGrammar(n-1, k-mid)==1)
                return 0;
            else
                return 1;
        }
    }

    public static void main(String[] args) {
        int  n = 5,k=3;
        System.out.println(kGrammar(n, k));
    }
}
