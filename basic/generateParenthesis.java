import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    public static void gen(String s, int o, int c, List<String> list) {
        if (o == 0 && c == 0) {
            list.add(s);
            return;
        }
        if (o > 0) {
            s += "(";
            gen(s, o - 1, c, list);
        }
        if (c > o) {
            if(s.length() != 1 && o>0)
                s = s.substring(0, s.length()-1);
            s += ")";
            gen(s, o, c - 1, list);
        }

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "(";
        int n = 3;
        int o = n - 1, c = n;
        gen(s,o,c,list);
        for(String h: list){
            System.out.println(h);
        }
    }
    
}
