package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class minWindowSubString {
    public static int slide(String r, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < r.length(); i++) {
            char t = r.charAt(i);
            if (map.containsKey(t))
                map.replace(t, map.get(t) + 1);
            else
                map.put(t, 1);
        }
        int n = s.length();
        int i = 0, j = 0, count = 0, min=Integer.MAX_VALUE;
        /*
         * for(char y:map.keySet()){ System.out.println(map.get(y)); }
         */
        count = map.size();
        while(j<n&&i<n){
            if(map.containsKey(s.charAt(j))&&count!=0){
                map.replace(s.charAt(j),map.get(s.charAt(j))-1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            //System.out.println("count: " + count);
            if(count==0){
                min = Math.min(j-i+1,min);
                /*for (char y : map.keySet()) {
                    System.out.println(y+" "+map.get(y));
                }*/
                //System.out.println(s.substring(i,j+1)+" "+i+" "+j);
                if (map.containsKey(s.charAt(i))) {
                    //System.out.println(s.charAt(i));
                    map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) > 0) {
                        count++;    
                        //System.out.println(s.charAt(i)+" "+ count);
                    }
                }
                i++;
                if(count>0)
                    j++;
                //System.out.println("=============="+s.substring(i, j + 1)+" "+ count+ " "+ map.get(s.charAt(i-1)));
                continue;
            }
            j++;
        }
        
        return min;
    }

    public static void main(String[] args) {
        String s = "dabcgartabc", r = "aabc";
        System.out.println(slide(r, s));
    }
}
