package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class longestSubStringnonRepeating {
    
    public static int slide(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0, count = 0, max = Integer.MIN_VALUE;
        while(j<n&&i<n){
            set.add(s.charAt(j));
            if(set.size()==j-i+1){
                count = j-i+1;
                max = Math.max(count,max);
                j++;
                continue;
            }else{
                set.remove(s.charAt(i));
                set.add(s.charAt(j));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcaefgdh";
        System.out.println(slide(s));
    }
}
