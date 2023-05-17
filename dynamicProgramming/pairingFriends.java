package dynamicProgramming;

public class pairingFriends{


    public static int func(int n, boolean bool, int i){
        if(bool){
            if(i==n)
                return 1;
            return func(n,!bool,i+1)+func(n,bool,i+1);
        }else{
            if(i==n)
                return 1;
            return func(n,bool,i+1)+func(n,!bool,i+1);
        }
    }
    public static void main(String[] args){
        int n = 1;
        System.out.println(func(n,false,1));
    }
}