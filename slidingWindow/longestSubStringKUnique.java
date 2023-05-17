package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//For Pick Toys k = 2
public class longestSubStringKUnique {
    

    public static int slide(int k, String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0, count = 0, max = Integer.MIN_VALUE;
        
        while(j<n){
            if(map.containsKey(Character.toString(s.charAt(j))))
                map.replace(Character.toString(s.charAt(j)),map.get(Character.toString(s.charAt(j)))+1);
            else
                map.put(Character.toString(s.charAt(j)),1);
            if(map.size()<k){
                j++;
                continue;
            }else if(map.size()==k){
                count = j-i+1;
                max = Math.max(max,count);
                j++;
            }else{
                if(map.get(Character.toString(s.charAt(i))) == 1){
                    map.remove(Character.toString(s.charAt(i)));
                }else{
                    map.replace(Character.toString(s.charAt(i)),map.get(Character.toString(s.charAt(i)))-1);
                }
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabcaadcaba";
        int k = 3;
        System.out.println(slide(k, s));
    }
}
