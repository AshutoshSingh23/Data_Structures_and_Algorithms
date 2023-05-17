import java.util.ArrayList;
import java.util.List;

public class printN_bitBinary {

    public static void gen(String s, int o, int z, int n, List<String> list) {
        if (n == 0) {
            list.add(s);
            return;
        }
        s += "1";
        gen(s, o + 1, z, n-1, list);
        
        if (z+1 <= o) {
            if (s.length() != 1)
                s = s.substring(0, s.length() - 1);
            s += "0";
            gen(s, o, z + 1, n-1, list);
        }

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "1";
        int n = 5;
        int o = 1, c = 0;
        gen(s, o, c, n-1, list);
        for (String h : list) {
            System.out.println(h);
        }
    }
    
}
