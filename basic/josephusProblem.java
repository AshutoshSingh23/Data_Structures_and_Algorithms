import java.util.ArrayList;
import java.util.List;

public class josephusProblem {
    
    public static int jos(int k, int pos, List<Integer> list){
        if(list.size() == 1)
            return list.get(0);
        if(pos>=list.size())
            pos = 0;
        pos = (pos+k-1)%list.size();
        list.remove(pos);
        return jos(k,pos,list);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int n = 16, k=2;
        for(int i=1;i<n+1;i++)
            list.add(i);
        System.out.println(jos(k,0,list));
    }
}
