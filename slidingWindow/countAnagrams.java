package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class countAnagrams {
    
    public static int slide(String r, String s) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<r.length();i++){
            String t = Character.toString(r.charAt(i));
            if(map.containsKey(t))
                map.replace(t, map.get(t)+1);
            else
                map.put(t,1);
        }
        Map<String, Integer> mp = new HashMap<>();
        mp.putAll(map);
        int n = r.length();
        int i=0,j=0,count=0;
        while(j<s.length()){
            if (j - i + 1 != r.length()) {
                if(map.containsKey(Character.toString(s.charAt(j)))){
                    map.replace(Character.toString(s.charAt(j)),map.get(Character.toString(s.charAt(j)))-1);
                    n--;
                }else{
                    map.clear();
                    map.putAll(mp);
                    n = r.length();
                }
                j++;
                continue;
            }
            if(n == 0){
                count++;
                map.clear();
                map.putAll(mp);
                n = r.length();
            }
            if(map.containsKey(Character.toString(s.charAt(j)))&&n<r.length()){
                map.replace(Character.toString(s.charAt(j)),map.get(Character.toString(s.charAt(j)))+1);
                n++;
            }
            i++;
            j++;
            if (j<s.length()&&map.containsKey(Character.toString(s.charAt(j)))) {
                map.replace(Character.toString(s.charAt(j)), map.get(Character.toString(s.charAt(j))) - 1);
                n--;
            } else {
                map.clear();
                map.putAll(mp);
                n = r.length();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aabcaabcaba",r = "aabc";
        System.out.println(slide(r, s));
    }
}
