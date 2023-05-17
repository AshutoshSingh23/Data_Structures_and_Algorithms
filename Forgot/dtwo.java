import java.util.*;

public class dtwo {

    public static boolean chk(String s, String r){
        for(int i=0;i<r.length();i++){
            if(s.charAt(i)!=r.charAt(i))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        String s =  sc.nextLine();
        String[] str = s.split(" ",n);
        Map<String,Integer> map = new HashMap<>();
        
        /*for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }*/

        for(int i=0;i<n;i++){
            map.put(str[i],i);
        }
        Arrays.sort(str);
        while(q>0){
            q--;
            int k = sc.nextInt();
            int x = 0,cnt=0;
            String si = sc.next();
            for(int i=0;i<n;i++){
                if(si.length()<=str[i].length()&&si.charAt(0)==str[i].charAt(0)){
                    cnt++;
                    if(cnt==k&&chk(str[i],si)){
                        x = 1;
                        System.out.println(map.get(str[i])+1);
                    }
                }
            }
            if(x==0)
                System.out.println(-1);
        }
        
        sc.close();
    }
}
