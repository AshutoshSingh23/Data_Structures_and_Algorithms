import java.util.*;

class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

public class graph01 {

	public static String multiple(int A) {
        if(A==0)
            return "0";
        if(A==1)
            return "1";
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("1",1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.second==0)
                return p.first;
            int rem0 = (p.second*10)%A;
            if(rem0==0)
                return p.first+"0";
            int rem1 = (p.second*10+1)%A;
            if(rem1==0)
                return p.first+"1";
            q.add(new Pair(p.first+"0",rem0));
            q.add(new Pair(p.first+"1",rem1));
        }
        return "";
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int A = sc.nextInt();
			System.out.println(multiple(A));
		}
		sc.close();
	}
}
