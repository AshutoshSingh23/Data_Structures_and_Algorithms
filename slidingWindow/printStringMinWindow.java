package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class printStringMinWindow {
    
    public static String slide(String r, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < r.length(); i++) {
            char t = r.charAt(i);
            if (map.containsKey(t))
                map.replace(t, map.get(t) + 1);
            else
                map.put(t, 1);
        }
        int n = s.length();
        int i = 0, j = 0, count = 0, min = Integer.MAX_VALUE;
        count = map.size();
        String u = "";
        while (j < n && i < n) {
            if (map.containsKey(s.charAt(j)) && count != 0) {
                map.replace(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            if (count == 0) {
                if(min>j-i+1){
                    if(j<n-1)
                        u = s.substring(i, j+1);
                    else
                        u = s.substring(i);
                }
                min = Math.min(j - i + 1, min);
                if (map.containsKey(s.charAt(i))) {
                    map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) > 0) {
                        count++;
                    }
                }
                i++;
                if (count > 0)
                    j++;
                continue;
            }
            j++;
        }

        return u;
    }

    public static void main(String[] args) {
        String s = "dabcgartabca", r = "aabc";
        System.out.println(slide(r, s));
    }
}
